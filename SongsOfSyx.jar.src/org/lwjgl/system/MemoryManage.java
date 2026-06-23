/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.lang.invoke.MethodHandles;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import org.lwjgl.system.libc.LibCStdlib;
/*     */ import org.lwjgl.system.libffi.FFIType;
/*     */ import org.lwjgl.system.libffi.LibFFI;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class MemoryManage
/*     */ {
/*     */   static MemoryUtil.MemoryAllocator getInstance() {
/*  28 */     Object allocator = Configuration.MEMORY_ALLOCATOR.get();
/*  29 */     if (allocator instanceof MemoryUtil.MemoryAllocator) {
/*  30 */       return (MemoryUtil.MemoryAllocator)allocator;
/*     */     }
/*     */     
/*  33 */     if (!"system".equals(allocator)) {
/*     */       String className;
/*  35 */       if (allocator == null || "jemalloc".equals(allocator)) {
/*  36 */         className = "org.lwjgl.system.jemalloc.JEmallocAllocator";
/*  37 */       } else if ("rpmalloc".equals(allocator)) {
/*  38 */         className = "org.lwjgl.system.rpmalloc.RPmallocAllocator";
/*     */       } else {
/*  40 */         className = allocator.toString();
/*     */       } 
/*     */       
/*     */       try {
/*  44 */         Class<?> allocatorClass = Class.forName(className);
/*  45 */         return allocatorClass.getConstructor(new Class[0]).newInstance(new Object[0]);
/*  46 */       } catch (Throwable t) {
/*  47 */         if (Checks.DEBUG && (allocator != null || !(t instanceof ClassNotFoundException))) {
/*  48 */           t.printStackTrace(APIUtil.DEBUG_STREAM);
/*     */         }
/*  50 */         APIUtil.apiLog(String.format("Warning: Failed to instantiate memory allocator: %s. Using the system default.", new Object[] { className }));
/*     */       } 
/*     */     } 
/*     */     
/*  54 */     return new StdlibAllocator();
/*     */   }
/*     */   
/*     */   private static class StdlibAllocator implements MemoryUtil.MemoryAllocator {
/*     */     private StdlibAllocator() {}
/*     */     
/*  60 */     public long getMalloc() { return MemoryAccessJNI.malloc; }
/*  61 */     public long getCalloc() { return MemoryAccessJNI.calloc; }
/*  62 */     public long getRealloc() { return MemoryAccessJNI.realloc; }
/*  63 */     public long getFree() { return MemoryAccessJNI.free; }
/*  64 */     public long getAlignedAlloc() { return MemoryAccessJNI.aligned_alloc; } public long getAlignedFree() {
/*  65 */       return MemoryAccessJNI.aligned_free;
/*     */     }
/*  67 */     public long malloc(long size) { return LibCStdlib.nmalloc(size); }
/*  68 */     public long calloc(long num, long size) { return LibCStdlib.ncalloc(num, size); }
/*  69 */     public long realloc(long ptr, long size) { return LibCStdlib.nrealloc(ptr, size); }
/*  70 */     public void free(long ptr) { LibCStdlib.nfree(ptr); }
/*  71 */     public long aligned_alloc(long alignment, long size) { return LibCStdlib.naligned_alloc(alignment, size); } public void aligned_free(long ptr) {
/*  72 */       LibCStdlib.naligned_free(ptr);
/*     */     }
/*     */   }
/*     */   
/*     */   static class DebugAllocator
/*     */     implements MemoryUtil.MemoryAllocator
/*     */   {
/*  79 */     private static final ConcurrentMap<Allocation, Allocation> ALLOCATIONS = new ConcurrentHashMap<>();
/*  80 */     private static final ConcurrentMap<Long, String> THREADS = new ConcurrentHashMap<>();
/*     */     
/*     */     private final MemoryUtil.MemoryAllocator allocator;
/*     */     
/*     */     private final long[] callbacks;
/*     */     
/*     */     DebugAllocator(MemoryUtil.MemoryAllocator allocator) {
/*  87 */       this.allocator = allocator;
/*     */       
/*  89 */       this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  95 */         .callbacks = new long[] { this::malloc.address(), this::calloc.address(), this::realloc.address(), this::free.address(), this::aligned_alloc.address(), this::aligned_free.address() };
/*     */ 
/*     */       
/*  98 */       Runtime.getRuntime().addShutdownHook(new Thread(() -> {
/*     */               for (long callback : this.callbacks) {
/*     */                 Callback.free(callback);
/*     */               }
/*     */               if (ALLOCATIONS.isEmpty()) {
/*     */                 return;
/*     */               }
/*     */               boolean missingStacktrace = false;
/*     */               for (Allocation allocation : ALLOCATIONS.keySet()) {
/*     */                 StringBuilder sb = new StringBuilder(512);
/*     */                 sb.append("[LWJGL] ").append(allocation.size).append(" bytes leaked, thread ").append(allocation.threadId).append(" (").append(THREADS.get(Long.valueOf(allocation.threadId))).append("), address: 0x").append(Long.toHexString(allocation.address).toUpperCase()).append("\n");
/*     */                 StackTraceElement[] stackTrace = allocation.getElements();
/*     */                 if (stackTrace != null) {
/*     */                   for (StackTraceElement el : stackTrace) {
/*     */                     sb.append("\tat ").append(el).append("\n");
/*     */                   }
/*     */                 } else {
/*     */                   missingStacktrace = true;
/*     */                 } 
/*     */                 APIUtil.DEBUG_STREAM.print(sb);
/*     */               } 
/*     */               if (missingStacktrace) {
/*     */                 APIUtil.DEBUG_STREAM.print("[LWJGL] Reminder: disable Configuration.DEBUG_MEMORY_ALLOCATOR_FAST to get stacktraces of leaking allocations.\n");
/*     */               }
/*     */             }));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @FunctionalInterface
/*     */     public static interface CallbackPP
/*     */       extends CallbackI
/*     */     {
/* 145 */       public static final Callback.Descriptor DESCRIPTOR = new Callback.Descriptor(MethodHandles.lookup(), APIUtil.apiCreateCIF(LibFFI.ffi_type_pointer, new FFIType[] { LibFFI.ffi_type_pointer })); default Callback.Descriptor getDescriptor() {
/* 146 */         return DESCRIPTOR;
/*     */       } default void callback(long ret, long args) {
/* 148 */         long size = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(args));
/* 149 */         MemoryUtil.memPutAddress(ret, invoke(size));
/*     */       }
/*     */       
/*     */       long invoke(long param2Long);
/*     */     }
/*     */     
/*     */     @FunctionalInterface
/* 156 */     public static interface CallbackPPP extends CallbackI { public static final Callback.Descriptor DESCRIPTOR = new Callback.Descriptor(MethodHandles.lookup(), APIUtil.apiCreateCIF(LibFFI.ffi_type_pointer, new FFIType[] { LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer })); default Callback.Descriptor getDescriptor() {
/* 157 */         return DESCRIPTOR;
/*     */       } default void callback(long ret, long args) {
/* 159 */         long num = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(args));
/* 160 */         long size = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(args + POINTER_SIZE));
/* 161 */         MemoryUtil.memPutAddress(ret, invoke(num, size));
/*     */       }
/*     */       
/*     */       long invoke(long param2Long1, long param2Long2); }
/*     */     
/*     */     @FunctionalInterface
/*     */     public static interface CallbackIV extends CallbackI {
/* 168 */       public static final Callback.Descriptor DESCRIPTOR = new Callback.Descriptor(MethodHandles.lookup(), APIUtil.apiCreateCIF(LibFFI.ffi_type_void, new FFIType[] { LibFFI.ffi_type_pointer })); default Callback.Descriptor getDescriptor() {
/* 169 */         return DESCRIPTOR;
/*     */       } default void callback(long ret, long args) {
/* 171 */         long ptr = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(args));
/* 172 */         invoke(ptr);
/*     */       }
/*     */       void invoke(long param2Long);
/*     */     }
/*     */     
/* 177 */     public long getMalloc() { return this.callbacks[0]; }
/* 178 */     public long getCalloc() { return this.callbacks[1]; }
/* 179 */     public long getRealloc() { return this.callbacks[2]; }
/* 180 */     public long getFree() { return this.callbacks[3]; }
/* 181 */     public long getAlignedAlloc() { return this.callbacks[4]; } public long getAlignedFree() {
/* 182 */       return this.callbacks[5];
/*     */     }
/*     */     public long malloc(long size) {
/* 185 */       return track(this.allocator.malloc(size), size);
/*     */     }
/*     */ 
/*     */     
/*     */     public long calloc(long num, long size) {
/* 190 */       return track(this.allocator.calloc(num, size), num * size);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long realloc(long ptr, long size) {
/* 208 */       long oldSize = untrack(ptr);
/*     */       
/* 210 */       long address = this.allocator.realloc(ptr, size);
/*     */       
/* 212 */       if (address != 0L) {
/* 213 */         track(address, size);
/* 214 */       } else if (size != 0L) {
/* 215 */         track(ptr, oldSize);
/*     */       } 
/*     */       
/* 218 */       return address;
/*     */     }
/*     */ 
/*     */     
/*     */     public void free(long ptr) {
/* 223 */       untrack(ptr);
/* 224 */       this.allocator.free(ptr);
/*     */     }
/*     */ 
/*     */     
/*     */     public long aligned_alloc(long alignment, long size) {
/* 229 */       return track(this.allocator.aligned_alloc(alignment, size), size);
/*     */     }
/*     */ 
/*     */     
/*     */     public void aligned_free(long ptr) {
/* 234 */       untrack(ptr);
/* 235 */       this.allocator.aligned_free(ptr);
/*     */     }
/*     */     
/*     */     static long track(long address, long size) {
/* 239 */       if (address != 0L) {
/* 240 */         Thread t = Thread.currentThread();
/* 241 */         THREADS.putIfAbsent(Long.valueOf(t.getId()), t.getName());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 247 */         Allocation allocationNew = new Allocation(address, size, t.getId(), ((Boolean)Configuration.DEBUG_MEMORY_ALLOCATOR_FAST.get(Boolean.valueOf(false))).booleanValue() ? null : StackWalkUtil.stackWalkGetTrace());
/*     */ 
/*     */         
/* 250 */         Allocation allocationOld = ALLOCATIONS.put(allocationNew, allocationNew);
/* 251 */         if (allocationOld != null) {
/* 252 */           trackAbort(address, allocationOld, allocationNew);
/*     */         }
/*     */       } 
/*     */       
/* 256 */       return address;
/*     */     }
/*     */     private static void trackAbort(long address, Allocation allocationOld, Allocation allocationNew) {
/* 259 */       String addressHex = Long.toHexString(address).toUpperCase();
/*     */       
/* 261 */       trackAbortPrint(allocationOld, "Old", addressHex);
/* 262 */       trackAbortPrint(allocationNew, "New", addressHex);
/*     */       
/* 264 */       throw new IllegalStateException("The memory address specified is already being tracked: 0x" + addressHex);
/*     */     }
/*     */     private static void trackAbortPrint(Allocation allocation, String name, String address) {
/* 267 */       StringBuilder sb = new StringBuilder(512);
/*     */       
/* 269 */       sb
/* 270 */         .append("[LWJGL] ")
/* 271 */         .append(name)
/* 272 */         .append(" allocation with size ")
/* 273 */         .append(allocation.size)
/* 274 */         .append(", thread ")
/* 275 */         .append(allocation.threadId)
/* 276 */         .append(" (")
/* 277 */         .append(THREADS.get(Long.valueOf(allocation.threadId)))
/* 278 */         .append("), address: 0x")
/* 279 */         .append(address)
/* 280 */         .append("\n");
/*     */       
/* 282 */       StackTraceElement[] stackTrace = allocation.getElements();
/* 283 */       if (stackTrace != null) {
/* 284 */         for (StackTraceElement el : stackTrace) {
/* 285 */           sb
/* 286 */             .append("\tat ")
/* 287 */             .append(el)
/* 288 */             .append("\n");
/*     */         }
/*     */       }
/*     */       
/* 292 */       APIUtil.DEBUG_STREAM.print(sb);
/*     */     }
/*     */     
/*     */     static long untrack(long address) {
/* 296 */       if (address == 0L) {
/* 297 */         return 0L;
/*     */       }
/*     */       
/* 300 */       Allocation allocation = ALLOCATIONS.remove(new Allocation(address, 0L, 0L, null));
/* 301 */       if (allocation == null) {
/* 302 */         throw untrackAbort(address);
/*     */       }
/*     */       
/* 305 */       return allocation.size;
/*     */     }
/*     */     private static IllegalStateException untrackAbort(long address) {
/* 308 */       String addressHex = Long.toHexString(address).toUpperCase();
/*     */       
/* 310 */       return new IllegalStateException("The memory address specified is not being tracked: 0x" + addressHex);
/*     */     }
/*     */ 
/*     */     
/*     */     private static class Allocation
/*     */     {
/*     */       final long address;
/*     */       final long size;
/*     */       final long threadId;
/*     */       private final Object[] stacktrace;
/*     */       
/*     */       Allocation(long address, long size, long threadId, Object[] stacktrace) {
/* 322 */         this.address = address;
/* 323 */         this.size = size;
/* 324 */         this.threadId = threadId;
/* 325 */         this.stacktrace = stacktrace;
/*     */       }
/*     */       
/*     */       private StackTraceElement[] getElements() {
/* 329 */         return (this.stacktrace == null) ? null : StackWalkUtil.stackWalkArray(this.stacktrace);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean equals(Object other) {
/* 335 */         return (this.address == ((Allocation)other).address);
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/* 340 */         return Long.hashCode(this.address);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     static void report(MemoryUtil.MemoryAllocationReport report) {
/* 346 */       for (Allocation allocation : ALLOCATIONS.keySet()) {
/* 347 */         report.invoke(allocation.address, allocation.size, allocation.threadId, THREADS.get(Long.valueOf(allocation.threadId)), allocation.getElements());
/*     */       }
/*     */     }
/*     */     
/*     */     private static <T> void aggregate(T t, long size, Map<T, AtomicLong> map) {
/* 352 */       AtomicLong node = map.computeIfAbsent(t, k -> new AtomicLong());
/* 353 */       node.set(node.get() + size);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static void report(MemoryUtil.MemoryAllocationReport report, MemoryUtil.MemoryAllocationReport.Aggregate groupByStackTrace, boolean groupByThread) {
/* 361 */       switch (groupByStackTrace) {
/*     */         case ALL:
/* 363 */           reportAll(report, groupByThread);
/*     */           break;
/*     */         case GROUP_BY_METHOD:
/* 366 */           reportByMethod(report, groupByThread);
/*     */           break;
/*     */         case GROUP_BY_STACKTRACE:
/* 369 */           reportByStacktrace(report, groupByThread);
/*     */           break;
/*     */       } 
/*     */     }
/*     */     private static void reportAll(MemoryUtil.MemoryAllocationReport report, boolean groupByThread) {
/* 374 */       if (groupByThread) {
/* 375 */         Map<Long, AtomicLong> mapThread = new HashMap<>();
/* 376 */         for (Allocation allocation : ALLOCATIONS.values()) {
/* 377 */           aggregate(Long.valueOf(allocation.threadId), allocation.size, mapThread);
/*     */         }
/* 379 */         for (Map.Entry<Long, AtomicLong> entry : mapThread.entrySet()) {
/* 380 */           report.invoke(0L, ((AtomicLong)entry.getValue()).get(), ((Long)entry.getKey()).longValue(), THREADS.get(entry.getKey()), (StackTraceElement[])null);
/*     */         }
/*     */       } else {
/* 383 */         long total = 0L;
/* 384 */         for (Allocation allocation : ALLOCATIONS.values()) {
/* 385 */           total += allocation.size;
/*     */         }
/* 387 */         report.invoke(0L, total, 0L, null, (StackTraceElement[])null);
/*     */       } 
/*     */     }
/*     */     
/*     */     private static void reportByMethod(MemoryUtil.MemoryAllocationReport report, boolean groupByThread) {
/* 392 */       if (groupByThread) {
/* 393 */         Map<Long, Map<StackTraceElement, AtomicLong>> mapThreadMethod = new HashMap<>();
/* 394 */         for (Allocation allocation : ALLOCATIONS.keySet()) {
/* 395 */           StackTraceElement[] elements = allocation.getElements();
/* 396 */           if (elements != null) {
/* 397 */             Map<StackTraceElement, AtomicLong> mapMethod = mapThreadMethod.computeIfAbsent(Long.valueOf(allocation.threadId), k -> new HashMap<>());
/* 398 */             aggregate(elements[0], allocation.size, mapMethod);
/*     */           } 
/*     */         } 
/*     */         
/* 402 */         for (Map.Entry<Long, Map<StackTraceElement, AtomicLong>> tms : mapThreadMethod.entrySet()) {
/* 403 */           long threadId = ((Long)tms.getKey()).longValue();
/* 404 */           String threadName = THREADS.get(Long.valueOf(threadId));
/* 405 */           for (Map.Entry<StackTraceElement, AtomicLong> ms : (Iterable<Map.Entry<StackTraceElement, AtomicLong>>)((Map)tms.getValue()).entrySet()) {
/* 406 */             report.invoke(0L, ((AtomicLong)ms.getValue()).get(), threadId, threadName, new StackTraceElement[] { ms.getKey() });
/*     */           } 
/*     */         } 
/*     */       } else {
/* 410 */         Map<StackTraceElement, AtomicLong> mapMethod = new HashMap<>();
/* 411 */         for (Allocation allocation : ALLOCATIONS.keySet()) {
/* 412 */           StackTraceElement[] elements = allocation.getElements();
/* 413 */           if (elements != null) {
/* 414 */             aggregate(elements[0], allocation.size, mapMethod);
/*     */           }
/*     */         } 
/* 417 */         for (Map.Entry<StackTraceElement, AtomicLong> ms : mapMethod.entrySet()) {
/* 418 */           report.invoke(0L, ((AtomicLong)ms.getValue()).get(), 0L, null, new StackTraceElement[] { ms.getKey() });
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     private static void reportByStacktrace(MemoryUtil.MemoryAllocationReport report, boolean groupByThread) {
/* 424 */       if (groupByThread) {
/* 425 */         Map<Long, Map<AllocationKey, AtomicLong>> mapThreadStackTrace = new HashMap<>();
/* 426 */         for (Allocation allocation : ALLOCATIONS.keySet()) {
/* 427 */           StackTraceElement[] elements = allocation.getElements();
/* 428 */           if (elements != null) {
/* 429 */             Map<AllocationKey, AtomicLong> mapStackTrace = mapThreadStackTrace.computeIfAbsent(Long.valueOf(allocation.threadId), k -> new HashMap<>());
/* 430 */             aggregate(new AllocationKey(elements), allocation.size, mapStackTrace);
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 435 */         for (Map.Entry<Long, Map<AllocationKey, AtomicLong>> tss : mapThreadStackTrace.entrySet()) {
/* 436 */           long threadId = ((Long)tss.getKey()).longValue();
/* 437 */           for (Map.Entry<AllocationKey, AtomicLong> ss : (Iterable<Map.Entry<AllocationKey, AtomicLong>>)((Map)tss.getValue()).entrySet()) {
/* 438 */             report.invoke(0L, ((AtomicLong)ss.getValue()).get(), threadId, THREADS.get(Long.valueOf(threadId)), ((AllocationKey)ss.getKey()).elements);
/*     */           }
/*     */         } 
/*     */       } else {
/* 442 */         Map<AllocationKey, AtomicLong> mapStackTrace = new HashMap<>();
/* 443 */         for (Allocation allocation : ALLOCATIONS.keySet()) {
/* 444 */           StackTraceElement[] elements = allocation.getElements();
/* 445 */           if (elements != null) {
/* 446 */             aggregate(new AllocationKey(elements), allocation.size, mapStackTrace);
/*     */           }
/*     */         } 
/* 449 */         for (Map.Entry<AllocationKey, AtomicLong> ss : mapStackTrace.entrySet()) {
/* 450 */           report.invoke(0L, ((AtomicLong)ss.getValue()).get(), 0L, null, ((AllocationKey)ss.getKey()).elements);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     private static class AllocationKey
/*     */     {
/*     */       final StackTraceElement[] elements;
/*     */       
/*     */       AllocationKey(StackTraceElement[] elements) {
/* 460 */         this.elements = elements;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(Object other) {
/* 465 */         return (this == other || Arrays.equals((Object[])this.elements, (Object[])((AllocationKey)other).elements));
/*     */       }
/*     */       
/*     */       public int hashCode() {
/* 469 */         return Arrays.hashCode((Object[])this.elements);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\MemoryManage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */