/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public abstract class Struct<SELF extends Struct<SELF>>
/*     */   extends Pointer.Default
/*     */ {
/*  20 */   protected static final int DEFAULT_PACK_ALIGNMENT = (Platform.get() == Platform.WINDOWS) ? 8 : 1073741824; protected static final int DEFAULT_ALIGN_AS = 0;
/*     */   protected ByteBuffer container;
/*     */   
/*     */   static {
/*  24 */     Library.initialize();
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
/*     */   protected Struct(long address, ByteBuffer container) {
/*  37 */     super(address);
/*  38 */     this.container = container;
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
/*     */   public void clear() {
/*  56 */     MemoryUtil.memSet(address(), 0, sizeof());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void free() {
/*  65 */     MemoryUtil.nmemFree(address());
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
/*     */   public boolean isNull(int memberOffset) {
/*  78 */     if (Checks.DEBUG) {
/*  79 */       checkMemberOffset(memberOffset);
/*     */     }
/*  81 */     return (MemoryUtil.memGetAddress(address() + memberOffset) == 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkMemberOffset(int memberOffset) {
/*  87 */     if (memberOffset < 0 || sizeof() - memberOffset < POINTER_SIZE) {
/*  88 */       throw new IllegalArgumentException("Invalid member offset.");
/*     */     }
/*     */   }
/*     */   
/*     */   protected static ByteBuffer __checkContainer(ByteBuffer container, int sizeof) {
/*  93 */     if (Checks.CHECKS) {
/*  94 */       Checks.check(container, sizeof);
/*     */     }
/*  96 */     return container;
/*     */   }
/*     */   
/*     */   private static long getBytes(int elements, int elementSize) {
/* 100 */     return (elements & 0xFFFFFFFFL) * elementSize;
/*     */   }
/*     */   
/*     */   protected static long __checkMalloc(int elements, int elementSize) {
/* 104 */     long bytes = (elements & 0xFFFFFFFFL) * elementSize;
/* 105 */     if (Checks.DEBUG) {
/* 106 */       if (elements < 0) {
/* 107 */         throw new IllegalArgumentException("Invalid number of elements");
/*     */       }
/* 109 */       if (BITS32 && 4294967295L < bytes) {
/* 110 */         throw new IllegalArgumentException("The request allocation is too large");
/*     */       }
/*     */     } 
/* 113 */     return bytes;
/*     */   }
/*     */   
/*     */   protected static ByteBuffer __create(int elements, int elementSize) {
/* 117 */     APIUtil.apiCheckAllocation(elements, getBytes(elements, elementSize), 2147483647L);
/* 118 */     return ByteBuffer.allocateDirect(elements * elementSize).order(ByteOrder.nativeOrder());
/*     */   }
/*     */   
/*     */   protected static <T extends Struct<T>> ByteBuffer __getContainer(T struct) {
/* 122 */     return ((Struct)struct).container;
/*     */   }
/*     */   
/*     */   protected static ByteBuffer __getContainer(StructBuffer<?, ?> struct) {
/* 126 */     return struct.container;
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
/*     */   public static void validate(long array, int count, int SIZEOF, StructValidation validation) {
/* 144 */     for (int i = 0; i < count; i++)
/* 145 */       validation.validate(array + Integer.toUnsignedLong(i) * SIZEOF); 
/*     */   }
/*     */   public static void validate(long array, long count, int SIZEOF, StructValidation validation) {
/* 148 */     validate(array, (int)count, SIZEOF, validation);
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface StructValidation {
/*     */     void validate(long param1Long); }
/*     */   
/*     */   protected static class Member {
/*     */     final int size;
/*     */     final int alignment;
/*     */     
/*     */     Member(int size, int alignment, boolean forcedAlignment) {
/* 160 */       this.size = size;
/* 161 */       this.alignment = alignment;
/* 162 */       this.forcedAlignment = forcedAlignment;
/*     */     }
/*     */     final boolean forcedAlignment; int offset;
/*     */     public int getSize() {
/* 166 */       return this.size;
/*     */     }
/*     */     
/*     */     public int getAlignment() {
/* 170 */       return this.alignment;
/*     */     }
/*     */     
/*     */     public int getAlignment(int packAlignment) {
/* 174 */       return this.forcedAlignment ? this.alignment : Math.min(this.alignment, packAlignment);
/*     */     }
/*     */   }
/*     */   
/*     */   protected static class Layout extends Member {
/*     */     final Struct.Member[] members;
/*     */     
/*     */     Layout(int size, int alignment, boolean forceAlignment, Struct.Member[] members) {
/* 182 */       super(size, alignment, forceAlignment);
/* 183 */       this.members = members;
/*     */     }
/*     */     
/*     */     public int offsetof(int member) {
/* 187 */       return (this.members[member]).offset;
/*     */     }
/*     */   }
/*     */   
/*     */   protected static Member __padding(int num, boolean condition) {
/* 192 */     return __padding(num, 1, condition);
/*     */   }
/*     */   
/*     */   protected static Member __padding(int num, int size, boolean condition) {
/* 196 */     return __member(condition ? (num * size) : 0, size);
/*     */   }
/*     */   
/*     */   protected static Member __member(int size) {
/* 200 */     return __member(size, size);
/*     */   }
/*     */   
/*     */   protected static Member __member(int size, int alignment) {
/* 204 */     return __member(size, alignment, false);
/*     */   }
/*     */   
/*     */   protected static Member __member(int size, int alignment, boolean forceAlignment) {
/* 208 */     return new Member(size, alignment, forceAlignment);
/*     */   }
/*     */   
/*     */   protected static Member __array(int size, int length) {
/* 212 */     return __array(size, size, length);
/*     */   }
/*     */   protected static Member __array(int size, int alignment, int length) {
/* 215 */     return new Member(size * length, alignment, false);
/*     */   }
/*     */   protected static Member __array(int size, int alignment, boolean forceAlignment, int length) {
/* 218 */     return new Member(size * length, alignment, forceAlignment);
/*     */   }
/*     */   protected static Layout __union(Member... members) {
/* 221 */     return __union(DEFAULT_PACK_ALIGNMENT, 0, members);
/*     */   } protected static Layout __union(int packAlignment, int alignas, Member... members) {
/* 223 */     List<Member> union = new ArrayList<>(members.length);
/*     */     
/* 225 */     int size = 0;
/* 226 */     int alignment = alignas;
/* 227 */     for (Member m : members) {
/* 228 */       size = Math.max(size, m.size);
/* 229 */       alignment = Math.max(alignment, m.getAlignment(packAlignment));
/*     */       
/* 231 */       m.offset = 0;
/* 232 */       union.add(m);
/* 233 */       if (m instanceof Layout) {
/* 234 */         addNestedMembers(m, union, 0);
/*     */       }
/*     */     } 
/*     */     
/* 238 */     return new Layout(size, alignment, (alignas != 0), union.<Member>toArray(new Member[0]));
/*     */   }
/*     */   protected static Layout __struct(Member... members) {
/* 241 */     return __struct(DEFAULT_PACK_ALIGNMENT, 0, members);
/*     */   } protected static Layout __struct(int packAlignment, int alignas, Member... members) {
/* 243 */     List<Member> struct = new ArrayList<>(members.length);
/*     */     
/* 245 */     int size = 0;
/* 246 */     int alignment = alignas;
/* 247 */     for (Member m : members) {
/* 248 */       int memberAlignment = m.getAlignment(packAlignment);
/*     */       
/* 250 */       m.offset = align(size, memberAlignment);
/*     */       
/* 252 */       size = m.offset + m.size;
/* 253 */       alignment = Math.max(alignment, memberAlignment);
/*     */       
/* 255 */       struct.add(m);
/* 256 */       if (m instanceof Layout) {
/* 257 */         addNestedMembers(m, struct, m.offset);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 262 */     size = align(size, alignment);
/*     */     
/* 264 */     return new Layout(size, alignment, (alignas != 0), struct.<Member>toArray(new Member[0]));
/*     */   }
/*     */   
/*     */   private static void addNestedMembers(Member nested, List<Member> members, int offset) {
/* 268 */     Layout layout = (Layout)nested;
/*     */     
/* 270 */     for (Member m : layout.members) {
/* 271 */       m.offset += offset;
/* 272 */       members.add(m);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static int align(int offset, int alignment) {
/* 277 */     return (offset - 1 | alignment - 1) + 1;
/*     */   }
/*     */   
/*     */   protected abstract SELF create(long paramLong, ByteBuffer paramByteBuffer);
/*     */   
/*     */   public abstract int sizeof();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\Struct.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */