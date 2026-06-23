/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.Field;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.nio.file.attribute.BasicFileAttributes;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import java.util.function.BiPredicate;
/*     */ import java.util.function.Predicate;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.stream.Stream;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.freebsd.FreeBSDLibrary;
/*     */ import org.lwjgl.system.libffi.FFICIF;
/*     */ import org.lwjgl.system.libffi.FFIType;
/*     */ import org.lwjgl.system.libffi.LibFFI;
/*     */ import org.lwjgl.system.linux.LinuxLibrary;
/*     */ import org.lwjgl.system.macosx.MacOSXLibrary;
/*     */ import org.lwjgl.system.windows.WindowsLibrary;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class APIUtil
/*     */ {
/*  42 */   public static final PrintStream DEBUG_STREAM = getDebugStream();
/*     */   
/*     */   private static final Pattern API_VERSION_PATTERN;
/*     */   
/*     */   static {
/*  47 */     String PREFIX = "[^\\d\\n\\r]*";
/*  48 */     String VERSION = "(\\d+)[.](\\d+)(?:[.](\\S+))?";
/*  49 */     String IMPLEMENTATION = "(?:\\s+(.+?))?\\s*";
/*     */     
/*  51 */     API_VERSION_PATTERN = Pattern.compile("^" + PREFIX + VERSION + IMPLEMENTATION + "$", 32);
/*     */   }
/*     */ 
/*     */   
/*     */   private static PrintStream getDebugStream() {
/*  56 */     PrintStream debugStream = System.err;
/*     */     
/*  58 */     Object state = Configuration.DEBUG_STREAM.get();
/*  59 */     if (state instanceof String) {
/*     */ 
/*     */       
/*     */       try {
/*  63 */         Supplier<PrintStream> factory = Class.forName((String)state).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
/*  64 */         debugStream = factory.get();
/*  65 */       } catch (Exception e) {
/*  66 */         e.printStackTrace();
/*     */       } 
/*  68 */     } else if (state instanceof Supplier) {
/*  69 */       debugStream = ((Supplier<PrintStream>)state).get();
/*  70 */     } else if (state instanceof PrintStream) {
/*  71 */       debugStream = (PrintStream)state;
/*     */     } 
/*     */     
/*  74 */     return debugStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void apiLog(CharSequence msg) {
/*  86 */     if (Checks.DEBUG) {
/*  87 */       DEBUG_STREAM.print("[LWJGL] " + msg + "\n");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void apiLogMore(CharSequence msg) {
/*  97 */     if (Checks.DEBUG) {
/*  98 */       DEBUG_STREAM.print("\t" + msg + "\n");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void apiLogMissing(String api, ByteBuffer functionName) {
/* 103 */     if (Checks.DEBUG) {
/* 104 */       String function = MemoryUtil.memASCII(functionName, functionName.remaining() - 1);
/* 105 */       DEBUG_STREAM.print("[LWJGL] Failed to locate address for " + api + " function " + function + "\n");
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String apiFindLibrary(String start, String name) {
/* 110 */     String libName = Platform.get().mapLibraryName(name);
/* 111 */     try (Stream<Path> paths = Files.find(
/* 112 */           Paths.get(start, new String[0]).toAbsolutePath(), 2147483647, (path, attributes) -> 
/*     */           
/* 114 */           (attributes.isRegularFile() && path.getFileName().toString().equals(libName)), new java.nio.file.FileVisitOption[0])) {
/*     */       
/* 116 */       return paths
/* 117 */         .findFirst()
/* 118 */         .map(Path::toString)
/* 119 */         .orElse(name);
/* 120 */     } catch (IOException e) {
/* 121 */       return name;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static SharedLibrary apiCreateLibrary(String name) {
/* 126 */     switch (Platform.get()) {
/*     */       case FREEBSD:
/* 128 */         return (SharedLibrary)new FreeBSDLibrary(name);
/*     */       case LINUX:
/* 130 */         return (SharedLibrary)new LinuxLibrary(name);
/*     */       case MACOSX:
/* 132 */         return (SharedLibrary)MacOSXLibrary.create(name);
/*     */       case WINDOWS:
/* 134 */         return (SharedLibrary)new WindowsLibrary(name);
/*     */     } 
/* 136 */     throw new IllegalStateException();
/*     */   }
/*     */ 
/*     */   
/*     */   public static long apiGetFunctionAddress(FunctionProvider provider, String functionName) {
/* 141 */     long a = provider.getFunctionAddress(functionName);
/* 142 */     if (a == 0L) {
/* 143 */       requiredFunctionMissing(functionName);
/*     */     }
/* 145 */     return a;
/*     */   }
/*     */   private static void requiredFunctionMissing(String functionName) {
/* 148 */     if (!((Boolean)Configuration.DISABLE_FUNCTION_CHECKS.get(Boolean.valueOf(false))).booleanValue()) {
/* 149 */       throw new NullPointerException("A required function is missing: " + functionName);
/*     */     }
/*     */   }
/*     */   
/*     */   public static long apiGetFunctionAddressOptional(SharedLibrary library, String functionName) {
/* 154 */     long a = library.getFunctionAddress(functionName);
/* 155 */     if (Checks.DEBUG_FUNCTIONS && a == 0L) {
/* 156 */       optionalFunctionMissing(library, functionName);
/*     */     }
/* 158 */     return a;
/*     */   }
/*     */   private static void optionalFunctionMissing(SharedLibrary library, String functionName) {
/* 161 */     if (Checks.DEBUG) {
/* 162 */       DEBUG_STREAM.print("[LWJGL] Failed to locate address for " + library.getName() + " function " + functionName + "\n");
/*     */     }
/*     */   }
/*     */   
/*     */   public static ByteBuffer apiGetMappedBuffer(ByteBuffer buffer, long mappedAddress, int capacity) {
/* 167 */     if (buffer != null && MemoryUtil.memAddress(buffer) == mappedAddress && buffer.capacity() == capacity) {
/* 168 */       return buffer;
/*     */     }
/* 170 */     return (mappedAddress == 0L) ? null : MemoryUtil.wrapBufferByte(mappedAddress, capacity);
/*     */   }
/*     */   
/*     */   public static long apiGetBytes(int elements, int elementShift) {
/* 174 */     return (elements & 0xFFFFFFFFL) << elementShift;
/*     */   }
/*     */   
/*     */   public static long apiCheckAllocation(int elements, long bytes, long maxBytes) {
/* 178 */     if (Checks.DEBUG) {
/* 179 */       if (elements < 0) {
/* 180 */         throw new IllegalArgumentException("Invalid number of elements");
/*     */       }
/* 182 */       if (maxBytes + Long.MIN_VALUE < bytes + Long.MIN_VALUE) {
/* 183 */         throw new IllegalArgumentException("The request allocation is too large");
/*     */       }
/*     */     } 
/* 186 */     return bytes;
/*     */   }
/*     */   
/*     */   public static interface Encoder
/*     */   {
/*     */     ByteBuffer encode(CharSequence param1CharSequence, boolean param1Boolean);
/*     */   }
/*     */   
/*     */   public static class APIVersion
/*     */     implements Comparable<APIVersion>
/*     */   {
/*     */     public final int major;
/*     */     public final int minor;
/*     */     public final String revision;
/*     */     public final String implementation;
/*     */     
/*     */     public APIVersion(int major, int minor) {
/* 203 */       this(major, minor, null, null);
/*     */     }
/*     */     
/*     */     public APIVersion(int major, int minor, String revision, String implementation) {
/* 207 */       this.major = major;
/* 208 */       this.minor = minor;
/* 209 */       this.revision = revision;
/* 210 */       this.implementation = implementation;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 215 */       StringBuilder sb = new StringBuilder(16);
/* 216 */       sb.append(this.major).append('.').append(this.minor);
/* 217 */       if (this.revision != null) {
/* 218 */         sb.append('.').append(this.revision);
/*     */       }
/* 220 */       if (this.implementation != null) {
/* 221 */         sb.append(" (").append(this.implementation).append(')');
/*     */       }
/* 223 */       return sb.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object o) {
/* 228 */       if (this == o) {
/* 229 */         return true;
/*     */       }
/* 231 */       if (!(o instanceof APIVersion)) {
/* 232 */         return false;
/*     */       }
/*     */       
/* 235 */       APIVersion that = (APIVersion)o;
/*     */       
/* 237 */       return (this.major == that.major && this.minor == that.major && 
/*     */         
/* 239 */         Objects.equals(this.revision, that.revision) && 
/* 240 */         Objects.equals(this.implementation, that.implementation));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 245 */       int result = this.major;
/* 246 */       result = 31 * result + this.minor;
/* 247 */       result = 31 * result + ((this.revision != null) ? this.revision.hashCode() : 0);
/* 248 */       result = 31 * result + ((this.implementation != null) ? this.implementation.hashCode() : 0);
/* 249 */       return result;
/*     */     }
/*     */ 
/*     */     
/*     */     public int compareTo(APIVersion other) {
/* 254 */       if (this.major != other.major) {
/* 255 */         return Integer.compare(this.major, other.major);
/*     */       }
/*     */       
/* 258 */       if (this.minor != other.minor) {
/* 259 */         return Integer.compare(this.minor, other.minor);
/*     */       }
/*     */       
/* 262 */       return 0;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static APIVersion apiParseVersion(Configuration<?> option) {
/*     */     APIVersion version;
/* 274 */     Object state = option.get();
/* 275 */     if (state instanceof String) {
/* 276 */       version = apiParseVersion((String)state);
/* 277 */     } else if (state instanceof APIVersion) {
/* 278 */       version = (APIVersion)state;
/*     */     } else {
/* 280 */       version = null;
/*     */     } 
/*     */     
/* 283 */     return version;
/*     */   }
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
/*     */   public static APIVersion apiParseVersion(String version) {
/* 298 */     Matcher matcher = API_VERSION_PATTERN.matcher(version);
/* 299 */     if (!matcher.matches()) {
/* 300 */       throw new IllegalArgumentException(String.format("Malformed API version string [%s]", new Object[] { version }));
/*     */     }
/*     */     
/* 303 */     return new APIVersion(
/* 304 */         Integer.parseInt(matcher.group(1)), 
/* 305 */         Integer.parseInt(matcher.group(2)), matcher
/* 306 */         .group(3), matcher
/* 307 */         .group(4));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void apiFilterExtensions(Set<String> extensions, Configuration<Object> option) {
/* 312 */     Object value = option.get();
/* 313 */     if (value == null) {
/*     */       return;
/*     */     }
/*     */     
/* 317 */     if (value instanceof String) {
/* 318 */       String s = (String)value;
/* 319 */       if (s.indexOf('.') != -1) {
/*     */ 
/*     */         
/*     */         try {
/* 323 */           Predicate<String> predicate = Class.forName(s).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
/* 324 */           extensions.removeIf(predicate);
/* 325 */         } catch (Exception e) {
/* 326 */           throw new RuntimeException(e);
/*     */         } 
/*     */       } else {
/* 329 */         for (String extension : s.split(",")) {
/* 330 */           extensions.remove(extension);
/*     */         }
/*     */       } 
/* 333 */     } else if (value instanceof List) {
/* 334 */       List<String> list = (List<String>)value;
/* 335 */       extensions.removeAll(list);
/* 336 */     } else if (value instanceof Predicate) {
/* 337 */       Predicate<String> predicate = (Predicate<String>)value;
/* 338 */       extensions.removeIf(predicate);
/*     */     } else {
/* 340 */       throw new IllegalStateException("Unsupported " + option.getProperty() + " value specified.");
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String apiUnknownToken(int token) {
/* 345 */     return apiUnknownToken("Unknown", token);
/*     */   }
/*     */   
/*     */   public static String apiUnknownToken(String description, int token) {
/* 349 */     return String.format("%s [0x%X]", new Object[] { description, Integer.valueOf(token) });
/*     */   }
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
/*     */   public static Map<Integer, String> apiClassTokens(BiPredicate<Field, Integer> filter, Map<Integer, String> target, Class<?>... tokenClasses) {
/* 365 */     if (target == null)
/*     */     {
/* 367 */       target = new HashMap<>(64);
/*     */     }
/*     */     
/* 370 */     int TOKEN_MODIFIERS = 25;
/*     */     
/* 372 */     for (Class<?> tokenClass : tokenClasses) {
/* 373 */       for (Field field : tokenClass.getDeclaredFields()) {
/*     */         
/* 375 */         if ((field.getModifiers() & TOKEN_MODIFIERS) == TOKEN_MODIFIERS && field.getType() == int.class) {
/*     */           try {
/* 377 */             Integer value = Integer.valueOf(field.getInt(null));
/* 378 */             if (filter == null || filter.test(field, value))
/*     */             
/*     */             { 
/*     */               
/* 382 */               String name = target.get(value);
/* 383 */               target.put(value, (name == null) ? field.getName() : (name + "|" + field.getName())); } 
/* 384 */           } catch (IllegalAccessException illegalAccessException) {}
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 391 */     return target;
/*     */   }
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
/*     */   public static long apiArray(MemoryStack stack, long... addresses) {
/* 405 */     PointerBuffer pointers = MemoryUtil.memPointerBuffer(stack.nmalloc(MemoryStack.POINTER_SIZE, addresses.length << MemoryStack.POINTER_SHIFT), addresses.length);
/*     */     
/* 407 */     for (long address : addresses) {
/* 408 */       pointers.put(address);
/*     */     }
/*     */     
/* 411 */     return pointers.address;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long apiArray(MemoryStack stack, ByteBuffer... buffers) {
/* 423 */     PointerBuffer pointers = MemoryUtil.memPointerBuffer(stack.nmalloc(MemoryStack.POINTER_SIZE, buffers.length << MemoryStack.POINTER_SHIFT), buffers.length);
/*     */     
/* 425 */     for (ByteBuffer buffer : buffers) {
/* 426 */       pointers.put(buffer);
/*     */     }
/*     */     
/* 429 */     return pointers.address;
/*     */   }
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
/*     */   public static long apiArrayp(MemoryStack stack, ByteBuffer... buffers) {
/* 442 */     long pointers = apiArray(stack, buffers);
/*     */     
/* 444 */     PointerBuffer lengths = stack.mallocPointer(buffers.length);
/* 445 */     for (ByteBuffer buffer : buffers) {
/* 446 */       lengths.put(buffer.remaining());
/*     */     }
/*     */     
/* 449 */     return pointers;
/*     */   }
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
/*     */   public static long apiArray(MemoryStack stack, Encoder encoder, CharSequence... strings) {
/* 469 */     PointerBuffer pointers = stack.mallocPointer(strings.length);
/*     */     
/* 471 */     for (CharSequence s : strings) {
/* 472 */       pointers.put(encoder.encode(s, true));
/*     */     }
/*     */     
/* 475 */     return pointers.address;
/*     */   }
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
/*     */   public static long apiArrayi(MemoryStack stack, Encoder encoder, CharSequence... strings) {
/* 492 */     PointerBuffer pointers = stack.mallocPointer(strings.length);
/* 493 */     IntBuffer lengths = stack.mallocInt(strings.length);
/*     */     
/* 495 */     for (CharSequence s : strings) {
/* 496 */       ByteBuffer buffer = encoder.encode(s, false);
/*     */       
/* 498 */       pointers.put(buffer);
/* 499 */       lengths.put(buffer.capacity());
/*     */     } 
/*     */     
/* 502 */     return pointers.address;
/*     */   }
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
/*     */   public static long apiArrayp(MemoryStack stack, Encoder encoder, CharSequence... strings) {
/* 519 */     PointerBuffer pointers = stack.mallocPointer(strings.length);
/* 520 */     PointerBuffer lengths = stack.mallocPointer(strings.length);
/*     */     
/* 522 */     for (CharSequence s : strings) {
/* 523 */       ByteBuffer buffer = encoder.encode(s, false);
/*     */       
/* 525 */       pointers.put(buffer);
/* 526 */       lengths.put(buffer.capacity());
/*     */     } 
/*     */     
/* 529 */     return pointers.address;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void apiArrayFree(long pointers, int length) {
/* 539 */     for (int i = length; --i >= 0;) {
/* 540 */       MemoryUtil.nmemFree(MemoryUtil.memGetAddress(pointers + Integer.toUnsignedLong(i) * MemoryStack.POINTER_SIZE));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFIType apiCreateStruct(FFIType... members) {
/* 549 */     MemoryUtil.MemoryAllocator allocator = MemoryUtil.getAllocator();
/*     */     
/* 551 */     PointerBuffer elementBuffer = PointerBuffer.create(allocator
/* 552 */         .malloc(((members.length + 1) * MemoryStack.POINTER_SIZE)), members.length + 1);
/*     */ 
/*     */     
/* 555 */     for (int i = 0; i < members.length; i++) {
/* 556 */       elementBuffer.put(i, (Pointer)members[i]);
/*     */     }
/* 558 */     elementBuffer.put(members.length, 0L);
/*     */     
/* 560 */     return FFIType.create(allocator.calloc(1L, FFIType.SIZEOF))
/* 561 */       .type((short)13)
/* 562 */       .elements(elementBuffer);
/*     */   }
/*     */   
/*     */   private static FFIType prep(FFIType type) {
/* 566 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/* 567 */       FFICIF cif = FFICIF.calloc(stack);
/* 568 */       if (LibFFI.ffi_prep_cif(cif, LibFFI.FFI_DEFAULT_ABI, type, null) != 0) {
/* 569 */         throw new IllegalStateException("Failed to prepare LibFFI type.");
/*     */       }
/*     */     } 
/* 572 */     return type;
/*     */   }
/*     */   
/*     */   public static FFIType apiCreateUnion(FFIType... members) {
/* 576 */     MemoryUtil.MemoryAllocator allocator = MemoryUtil.getAllocator();
/*     */ 
/*     */     
/* 579 */     FFIType maxType = prep(members[0]);
/* 580 */     short maxAlignment = members[0].alignment();
/* 581 */     for (int i = 1; i < members.length; i++) {
/* 582 */       FFIType type = prep(members[i]);
/* 583 */       if (maxType.size() < type.size()) {
/* 584 */         maxType = type;
/*     */       }
/* 586 */       if (maxAlignment < type.alignment()) {
/* 587 */         maxAlignment = type.alignment();
/*     */       }
/*     */     } 
/*     */     
/* 591 */     return FFIType.create(allocator.malloc(FFIType.SIZEOF))
/* 592 */       .size(maxType.size())
/* 593 */       .alignment(maxAlignment)
/* 594 */       .type((short)13)
/* 595 */       .elements(PointerBuffer.create(allocator.malloc((2 * MemoryStack.POINTER_SIZE)), 2)
/* 596 */         .put(0, (Pointer)maxType)
/* 597 */         .put(1, 0L));
/*     */   }
/*     */   
/*     */   public static FFIType apiCreateArray(FFIType type, int length) {
/* 601 */     MemoryUtil.MemoryAllocator allocator = MemoryUtil.getAllocator();
/*     */     
/* 603 */     PointerBuffer elementBuffer = PointerBuffer.create(allocator
/* 604 */         .malloc(((length + 1) * MemoryStack.POINTER_SIZE)), length + 1);
/*     */ 
/*     */     
/* 607 */     for (int i = 0; i < length; i++) {
/* 608 */       elementBuffer.put(i, (Pointer)type);
/*     */     }
/* 610 */     elementBuffer.put(length, 0L);
/*     */     
/* 612 */     return FFIType.create(allocator.calloc(1L, FFIType.SIZEOF))
/* 613 */       .type((short)13)
/* 614 */       .elements(elementBuffer);
/*     */   }
/*     */   
/*     */   public static FFICIF apiCreateCIF(FFIType rtype, FFIType... atypes) {
/* 618 */     return apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, rtype, atypes);
/*     */   }
/*     */   
/*     */   public static FFICIF apiCreateCIF(int abi, FFIType rtype, FFIType... atypes) {
/* 622 */     MemoryUtil.MemoryAllocator allocator = MemoryUtil.getAllocator();
/*     */     
/* 624 */     PointerBuffer pArgTypes = PointerBuffer.create(allocator.malloc((atypes.length * MemoryStack.POINTER_SIZE)), atypes.length);
/* 625 */     for (int i = 0; i < atypes.length; i++) {
/* 626 */       pArgTypes.put(i, (Pointer)atypes[i]);
/*     */     }
/*     */     
/* 629 */     FFICIF cif = FFICIF.create(allocator.malloc(FFICIF.SIZEOF));
/*     */     
/* 631 */     int errcode = LibFFI.ffi_prep_cif(cif, abi, rtype, pArgTypes);
/* 632 */     if (errcode != 0) {
/* 633 */       throw new IllegalStateException("Failed to prepare libffi CIF: " + errcode);
/*     */     }
/*     */     
/* 636 */     return cif;
/*     */   }
/*     */   
/*     */   public static FFICIF apiCreateCIFVar(int nfixedargs, FFIType rtype, FFIType... atypes) {
/* 640 */     return apiCreateCIFVar(LibFFI.FFI_DEFAULT_ABI, nfixedargs, rtype, atypes);
/*     */   }
/*     */   
/*     */   public static FFICIF apiCreateCIFVar(int abi, int nfixedargs, FFIType rtype, FFIType... atypes) {
/* 644 */     MemoryUtil.MemoryAllocator allocator = MemoryUtil.getAllocator();
/*     */     
/* 646 */     PointerBuffer pArgTypes = PointerBuffer.create(allocator.malloc((atypes.length * MemoryStack.POINTER_SIZE)), atypes.length);
/* 647 */     for (int i = 0; i < atypes.length; i++) {
/* 648 */       pArgTypes.put(i, (Pointer)atypes[i]);
/*     */     }
/*     */     
/* 651 */     FFICIF cif = FFICIF.create(allocator.malloc(FFICIF.SIZEOF));
/*     */     
/* 653 */     int errcode = LibFFI.ffi_prep_cif_var(cif, abi, nfixedargs, rtype, pArgTypes);
/* 654 */     if (errcode != 0) {
/* 655 */       throw new IllegalStateException("Failed to prepare libffi var CIF: " + errcode);
/*     */     }
/*     */     
/* 658 */     return cif;
/*     */   }
/*     */   
/*     */   public static int apiStdcall() {
/* 662 */     return (MemoryStack.BITS64 || Platform.get() != Platform.WINDOWS) ? LibFFI.FFI_DEFAULT_ABI : LibFFI.FFI_STDCALL;
/*     */   }
/*     */   
/* 665 */   public static void apiClosureRet(long ret, boolean __result) { MemoryUtil.memPutAddress(ret, __result ? 1L : 0L); }
/* 666 */   public static void apiClosureRet(long ret, byte __result) { MemoryUtil.memPutAddress(ret, __result & 0xFFL); }
/* 667 */   public static void apiClosureRet(long ret, short __result) { MemoryUtil.memPutAddress(ret, __result & 0xFFFFL); }
/* 668 */   public static void apiClosureRet(long ret, int __result) { MemoryUtil.memPutAddress(ret, __result & 0xFFFFFFFFL); }
/* 669 */   public static void apiClosureRetL(long ret, long __result) { MemoryUtil.memPutLong(ret, __result); }
/* 670 */   public static void apiClosureRetP(long ret, long __result) { MemoryUtil.memPutAddress(ret, __result); }
/* 671 */   public static void apiClosureRet(long ret, float __result) { MemoryUtil.memPutFloat(ret, __result); } public static void apiClosureRet(long ret, double __result) {
/* 672 */     MemoryUtil.memPutDouble(ret, __result);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\APIUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */