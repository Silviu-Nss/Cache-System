This program implements 3 types of cache: LRU, FIFO and LFU (least recently used, first in first out, least frequently used). It accepts 2 opperations:

  - ADD name_object basic premium : adds an element in memory or updates it
  Example: ADD name 3 5, meaning that we have 5 premium accesses and 3 basic accesses.
  
  - GET name_object : returns 0 if it is in cache, 1 if it is in memory and 2 otherwise
