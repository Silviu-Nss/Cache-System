/**
 *
 * @author Nastasescu George-Silviu, 321CB
 */

import java.io.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        
        File file_in = new File(args[0]);
        File file_out = new File(args[1]);
        PrintWriter out = new PrintWriter(file_out);
        Memorie mem = new Memorie(10000);
        Memorie cache;
        Scanner input = new Scanner(file_in);
        String tip_cache = input.nextLine();
        String cmd = input.nextLine();
        int len_cache = Integer.parseInt(cmd);
        cmd = input.nextLine();
        int nr_comenzi = Integer.parseInt(cmd);
        
        switch (tip_cache) {
            case "LRU":
                cache = new LRUCache(len_cache);
                break;
            case "LFU":
                cache = new LFUCache(len_cache);
                break;
            default:
                cache = new FIFOCache(len_cache);
                break;
        }
        
        for(int i = 0; i < nr_comenzi; i++) {
            String comanda = input.nextLine();
            String[] tok = comanda.split(" ");
            if(tok[0].equals("ADD")) {
                switch (tok.length) {
                    case 4:
                        {
                            int nr_pr = Integer.parseInt(tok[3]);
                            int nr_basic = Integer.parseInt(tok[2]);
                            Premium pr = new Premium(tok[1], nr_basic, nr_pr);
                            mem.add(pr);
                            cache.removeAdd(pr);
                            break;
                        }
                    case 3:
                        {
                            int nr_basic = Integer.parseInt(tok[2]);
                            Basic basic = new Basic(tok[1], nr_basic);
                            mem.add(basic);
                            cache.removeAdd(basic);
                            break;
                        }
                    default:
                        Free free = new Free(tok[1]);
                        cache.removeAdd(free);
                        mem.add(free);
                        break;
                }
                    
            }
            else {
                Free free = new Free(tok[1]);
                int index = mem.search(free);
                if(index == -1) {
                    out.print("2");
                    out.print("\n");
                    continue;
                }
                Subscriptie s = mem.getArrayElem(index);
                if(cache.search(free) == -1)  {
                    cache.add(s);
                    out.print("1 ");
                }
                else
                    out.print("0 ");
                out.print(s.display());
                out.print("\n");
                s.dec();
            }
        }
        out.flush();
	out.close();
        input.close();
    }
}
