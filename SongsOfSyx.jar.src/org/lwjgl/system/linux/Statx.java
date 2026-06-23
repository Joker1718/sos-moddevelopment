/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import java.util.function.Consumer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Struct;
/*     */ import org.lwjgl.system.StructBuffer;
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
/*     */ 
/*     */ @NativeType("struct statx")
/*     */ public class Statx
/*     */   extends Struct<Statx>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int STX_MASK;
/*     */   public static final int STX_BLKSIZE;
/*     */   public static final int STX_ATTRIBUTES;
/*     */   public static final int STX_NLINK;
/*     */   public static final int STX_UID;
/*     */   public static final int STX_GID;
/*     */   public static final int STX_MODE;
/*     */   public static final int __SPARE0;
/*     */   public static final int STX_INO;
/*     */   public static final int STX_SIZE;
/*     */   public static final int STX_BLOCKS;
/*     */   public static final int STX_ATTRIBUTES_MASK;
/*     */   public static final int STX_ATIME;
/*     */   public static final int STX_BTIME;
/*     */   public static final int STX_CTIME;
/*     */   public static final int STX_MTIME;
/*     */   public static final int STX_RDEV_MAJOR;
/*     */   public static final int STX_RDEV_MINOR;
/*     */   public static final int STX_DEV_MAJOR;
/*     */   public static final int STX_DEV_MINOR;
/*     */   public static final int STX_MNT_ID;
/*     */   public static final int __SPARE2;
/*     */   public static final int __SPARE3;
/*     */   
/*     */   static {
/*  83 */     Struct.Layout layout = __struct(new Struct.Member[] { 
/*  84 */           __member(4), 
/*  85 */           __member(4), 
/*  86 */           __member(8), 
/*  87 */           __member(4), 
/*  88 */           __member(4), 
/*  89 */           __member(4), 
/*  90 */           __member(2), 
/*  91 */           __array(2, 1), 
/*  92 */           __member(8), 
/*  93 */           __member(8), 
/*  94 */           __member(8), 
/*  95 */           __member(8), 
/*  96 */           __member(StatxTimestamp.SIZEOF, StatxTimestamp.ALIGNOF), 
/*  97 */           __member(StatxTimestamp.SIZEOF, StatxTimestamp.ALIGNOF), 
/*  98 */           __member(StatxTimestamp.SIZEOF, StatxTimestamp.ALIGNOF), 
/*  99 */           __member(StatxTimestamp.SIZEOF, StatxTimestamp.ALIGNOF), 
/* 100 */           __member(4), 
/* 101 */           __member(4), 
/* 102 */           __member(4), 
/* 103 */           __member(4), 
/* 104 */           __member(8), 
/* 105 */           __member(8), 
/* 106 */           __array(8, 12) });
/*     */ 
/*     */     
/* 109 */     SIZEOF = layout.getSize();
/* 110 */     ALIGNOF = layout.getAlignment();
/*     */     
/* 112 */     STX_MASK = layout.offsetof(0);
/* 113 */     STX_BLKSIZE = layout.offsetof(1);
/* 114 */     STX_ATTRIBUTES = layout.offsetof(2);
/* 115 */     STX_NLINK = layout.offsetof(3);
/* 116 */     STX_UID = layout.offsetof(4);
/* 117 */     STX_GID = layout.offsetof(5);
/* 118 */     STX_MODE = layout.offsetof(6);
/* 119 */     __SPARE0 = layout.offsetof(7);
/* 120 */     STX_INO = layout.offsetof(8);
/* 121 */     STX_SIZE = layout.offsetof(9);
/* 122 */     STX_BLOCKS = layout.offsetof(10);
/* 123 */     STX_ATTRIBUTES_MASK = layout.offsetof(11);
/* 124 */     STX_ATIME = layout.offsetof(12);
/* 125 */     STX_BTIME = layout.offsetof(13);
/* 126 */     STX_CTIME = layout.offsetof(14);
/* 127 */     STX_MTIME = layout.offsetof(15);
/* 128 */     STX_RDEV_MAJOR = layout.offsetof(16);
/* 129 */     STX_RDEV_MINOR = layout.offsetof(17);
/* 130 */     STX_DEV_MAJOR = layout.offsetof(18);
/* 131 */     STX_DEV_MINOR = layout.offsetof(19);
/* 132 */     STX_MNT_ID = layout.offsetof(20);
/* 133 */     __SPARE2 = layout.offsetof(21);
/* 134 */     __SPARE3 = layout.offsetof(22);
/*     */   }
/*     */   
/*     */   protected Statx(long address, ByteBuffer container) {
/* 138 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Statx create(long address, ByteBuffer container) {
/* 143 */     return new Statx(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Statx(ByteBuffer container) {
/* 153 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 157 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int stx_mask() {
/* 161 */     return nstx_mask(address());
/*     */   } @NativeType("__u32")
/*     */   public int stx_blksize() {
/* 164 */     return nstx_blksize(address());
/*     */   } @NativeType("__u64")
/*     */   public long stx_attributes() {
/* 167 */     return nstx_attributes(address());
/*     */   } @NativeType("__u32")
/*     */   public int stx_nlink() {
/* 170 */     return nstx_nlink(address());
/*     */   } @NativeType("__u32")
/*     */   public int stx_uid() {
/* 173 */     return nstx_uid(address());
/*     */   } @NativeType("__u32")
/*     */   public int stx_gid() {
/* 176 */     return nstx_gid(address());
/*     */   } @NativeType("__u16")
/*     */   public short stx_mode() {
/* 179 */     return nstx_mode(address());
/*     */   } @NativeType("__u64")
/*     */   public long stx_ino() {
/* 182 */     return nstx_ino(address());
/*     */   } @NativeType("__u64")
/*     */   public long stx_size() {
/* 185 */     return nstx_size(address());
/*     */   } @NativeType("__u64")
/*     */   public long stx_blocks() {
/* 188 */     return nstx_blocks(address());
/*     */   } @NativeType("__u64")
/*     */   public long stx_attributes_mask() {
/* 191 */     return nstx_attributes_mask(address());
/*     */   } @NativeType("struct statx_timestamp")
/*     */   public StatxTimestamp stx_atime() {
/* 194 */     return nstx_atime(address());
/*     */   } @NativeType("struct statx_timestamp")
/*     */   public StatxTimestamp stx_btime() {
/* 197 */     return nstx_btime(address());
/*     */   } @NativeType("struct statx_timestamp")
/*     */   public StatxTimestamp stx_ctime() {
/* 200 */     return nstx_ctime(address());
/*     */   } @NativeType("struct statx_timestamp")
/*     */   public StatxTimestamp stx_mtime() {
/* 203 */     return nstx_mtime(address());
/*     */   } @NativeType("__u32")
/*     */   public int stx_rdev_major() {
/* 206 */     return nstx_rdev_major(address());
/*     */   } @NativeType("__u32")
/*     */   public int stx_rdev_minor() {
/* 209 */     return nstx_rdev_minor(address());
/*     */   } @NativeType("__u32")
/*     */   public int stx_dev_major() {
/* 212 */     return nstx_dev_major(address());
/*     */   } @NativeType("__u32")
/*     */   public int stx_dev_minor() {
/* 215 */     return nstx_dev_minor(address());
/*     */   } @NativeType("__u64")
/*     */   public long stx_mnt_id() {
/* 218 */     return nstx_mnt_id(address());
/*     */   }
/*     */   public Statx stx_mask(@NativeType("__u32") int value) {
/* 221 */     nstx_mask(address(), value); return this;
/*     */   } public Statx stx_blksize(@NativeType("__u32") int value) {
/* 223 */     nstx_blksize(address(), value); return this;
/*     */   } public Statx stx_attributes(@NativeType("__u64") long value) {
/* 225 */     nstx_attributes(address(), value); return this;
/*     */   } public Statx stx_nlink(@NativeType("__u32") int value) {
/* 227 */     nstx_nlink(address(), value); return this;
/*     */   } public Statx stx_uid(@NativeType("__u32") int value) {
/* 229 */     nstx_uid(address(), value); return this;
/*     */   } public Statx stx_gid(@NativeType("__u32") int value) {
/* 231 */     nstx_gid(address(), value); return this;
/*     */   } public Statx stx_mode(@NativeType("__u16") short value) {
/* 233 */     nstx_mode(address(), value); return this;
/*     */   } public Statx stx_ino(@NativeType("__u64") long value) {
/* 235 */     nstx_ino(address(), value); return this;
/*     */   } public Statx stx_size(@NativeType("__u64") long value) {
/* 237 */     nstx_size(address(), value); return this;
/*     */   } public Statx stx_blocks(@NativeType("__u64") long value) {
/* 239 */     nstx_blocks(address(), value); return this;
/*     */   } public Statx stx_attributes_mask(@NativeType("__u64") long value) {
/* 241 */     nstx_attributes_mask(address(), value); return this;
/*     */   } public Statx stx_atime(@NativeType("struct statx_timestamp") StatxTimestamp value) {
/* 243 */     nstx_atime(address(), value); return this;
/*     */   } public Statx stx_atime(Consumer<StatxTimestamp> consumer) {
/* 245 */     consumer.accept(stx_atime()); return this;
/*     */   } public Statx stx_btime(@NativeType("struct statx_timestamp") StatxTimestamp value) {
/* 247 */     nstx_btime(address(), value); return this;
/*     */   } public Statx stx_btime(Consumer<StatxTimestamp> consumer) {
/* 249 */     consumer.accept(stx_btime()); return this;
/*     */   } public Statx stx_ctime(@NativeType("struct statx_timestamp") StatxTimestamp value) {
/* 251 */     nstx_ctime(address(), value); return this;
/*     */   } public Statx stx_ctime(Consumer<StatxTimestamp> consumer) {
/* 253 */     consumer.accept(stx_ctime()); return this;
/*     */   } public Statx stx_mtime(@NativeType("struct statx_timestamp") StatxTimestamp value) {
/* 255 */     nstx_mtime(address(), value); return this;
/*     */   } public Statx stx_mtime(Consumer<StatxTimestamp> consumer) {
/* 257 */     consumer.accept(stx_mtime()); return this;
/*     */   } public Statx stx_rdev_major(@NativeType("__u32") int value) {
/* 259 */     nstx_rdev_major(address(), value); return this;
/*     */   } public Statx stx_rdev_minor(@NativeType("__u32") int value) {
/* 261 */     nstx_rdev_minor(address(), value); return this;
/*     */   } public Statx stx_dev_major(@NativeType("__u32") int value) {
/* 263 */     nstx_dev_major(address(), value); return this;
/*     */   } public Statx stx_dev_minor(@NativeType("__u32") int value) {
/* 265 */     nstx_dev_minor(address(), value); return this;
/*     */   } public Statx stx_mnt_id(@NativeType("__u64") long value) {
/* 267 */     nstx_mnt_id(address(), value); return this;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Statx set(int stx_mask, int stx_blksize, long stx_attributes, int stx_nlink, int stx_uid, int stx_gid, short stx_mode, long stx_ino, long stx_size, long stx_blocks, long stx_attributes_mask, StatxTimestamp stx_atime, StatxTimestamp stx_btime, StatxTimestamp stx_ctime, StatxTimestamp stx_mtime, int stx_rdev_major, int stx_rdev_minor, int stx_dev_major, int stx_dev_minor, long stx_mnt_id) {
/* 292 */     stx_mask(stx_mask);
/* 293 */     stx_blksize(stx_blksize);
/* 294 */     stx_attributes(stx_attributes);
/* 295 */     stx_nlink(stx_nlink);
/* 296 */     stx_uid(stx_uid);
/* 297 */     stx_gid(stx_gid);
/* 298 */     stx_mode(stx_mode);
/* 299 */     stx_ino(stx_ino);
/* 300 */     stx_size(stx_size);
/* 301 */     stx_blocks(stx_blocks);
/* 302 */     stx_attributes_mask(stx_attributes_mask);
/* 303 */     stx_atime(stx_atime);
/* 304 */     stx_btime(stx_btime);
/* 305 */     stx_ctime(stx_ctime);
/* 306 */     stx_mtime(stx_mtime);
/* 307 */     stx_rdev_major(stx_rdev_major);
/* 308 */     stx_rdev_minor(stx_rdev_minor);
/* 309 */     stx_dev_major(stx_dev_major);
/* 310 */     stx_dev_minor(stx_dev_minor);
/* 311 */     stx_mnt_id(stx_mnt_id);
/*     */     
/* 313 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Statx set(Statx src) {
/* 324 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 325 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Statx malloc() {
/* 332 */     return new Statx(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Statx calloc() {
/* 337 */     return new Statx(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Statx create() {
/* 342 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 343 */     return new Statx(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Statx create(long address) {
/* 348 */     return new Statx(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Statx createSafe(long address) {
/* 353 */     return (address == 0L) ? null : new Statx(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 362 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 371 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 380 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 381 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 391 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 396 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Statx malloc(MemoryStack stack) {
/* 405 */     return new Statx(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Statx calloc(MemoryStack stack) {
/* 414 */     return new Statx(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 424 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 434 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nstx_mask(long struct) {
/* 440 */     return MemoryUtil.memGetInt(struct + STX_MASK);
/*     */   } public static int nstx_blksize(long struct) {
/* 442 */     return MemoryUtil.memGetInt(struct + STX_BLKSIZE);
/*     */   } public static long nstx_attributes(long struct) {
/* 444 */     return MemoryUtil.memGetLong(struct + STX_ATTRIBUTES);
/*     */   } public static int nstx_nlink(long struct) {
/* 446 */     return MemoryUtil.memGetInt(struct + STX_NLINK);
/*     */   } public static int nstx_uid(long struct) {
/* 448 */     return MemoryUtil.memGetInt(struct + STX_UID);
/*     */   } public static int nstx_gid(long struct) {
/* 450 */     return MemoryUtil.memGetInt(struct + STX_GID);
/*     */   }
/* 452 */   public static short nstx_mode(long struct) { return MemoryUtil.memGetShort(struct + STX_MODE); } public static ShortBuffer n__spare0(long struct) {
/* 453 */     return MemoryUtil.memShortBuffer(struct + __SPARE0, 1);
/*     */   } public static short n__spare0(long struct, int index) {
/* 455 */     return MemoryUtil.memGetShort(struct + __SPARE0 + Checks.check(index, 1) * 2L);
/*     */   }
/*     */   public static long nstx_ino(long struct) {
/* 458 */     return MemoryUtil.memGetLong(struct + STX_INO);
/*     */   } public static long nstx_size(long struct) {
/* 460 */     return MemoryUtil.memGetLong(struct + STX_SIZE);
/*     */   } public static long nstx_blocks(long struct) {
/* 462 */     return MemoryUtil.memGetLong(struct + STX_BLOCKS);
/*     */   } public static long nstx_attributes_mask(long struct) {
/* 464 */     return MemoryUtil.memGetLong(struct + STX_ATTRIBUTES_MASK);
/*     */   } public static StatxTimestamp nstx_atime(long struct) {
/* 466 */     return StatxTimestamp.create(struct + STX_ATIME);
/*     */   } public static StatxTimestamp nstx_btime(long struct) {
/* 468 */     return StatxTimestamp.create(struct + STX_BTIME);
/*     */   } public static StatxTimestamp nstx_ctime(long struct) {
/* 470 */     return StatxTimestamp.create(struct + STX_CTIME);
/*     */   } public static StatxTimestamp nstx_mtime(long struct) {
/* 472 */     return StatxTimestamp.create(struct + STX_MTIME);
/*     */   } public static int nstx_rdev_major(long struct) {
/* 474 */     return MemoryUtil.memGetInt(struct + STX_RDEV_MAJOR);
/*     */   } public static int nstx_rdev_minor(long struct) {
/* 476 */     return MemoryUtil.memGetInt(struct + STX_RDEV_MINOR);
/*     */   } public static int nstx_dev_major(long struct) {
/* 478 */     return MemoryUtil.memGetInt(struct + STX_DEV_MAJOR);
/*     */   } public static int nstx_dev_minor(long struct) {
/* 480 */     return MemoryUtil.memGetInt(struct + STX_DEV_MINOR);
/*     */   }
/* 482 */   public static long nstx_mnt_id(long struct) { return MemoryUtil.memGetLong(struct + STX_MNT_ID); }
/* 483 */   public static long n__spare2(long struct) { return MemoryUtil.memGetLong(struct + __SPARE2); } public static LongBuffer n__spare3(long struct) {
/* 484 */     return MemoryUtil.memLongBuffer(struct + __SPARE3, 12);
/*     */   } public static long n__spare3(long struct, int index) {
/* 486 */     return MemoryUtil.memGetLong(struct + __SPARE3 + Checks.check(index, 12) * 8L);
/*     */   }
/*     */   
/*     */   public static void nstx_mask(long struct, int value) {
/* 490 */     MemoryUtil.memPutInt(struct + STX_MASK, value);
/*     */   } public static void nstx_blksize(long struct, int value) {
/* 492 */     MemoryUtil.memPutInt(struct + STX_BLKSIZE, value);
/*     */   } public static void nstx_attributes(long struct, long value) {
/* 494 */     MemoryUtil.memPutLong(struct + STX_ATTRIBUTES, value);
/*     */   } public static void nstx_nlink(long struct, int value) {
/* 496 */     MemoryUtil.memPutInt(struct + STX_NLINK, value);
/*     */   } public static void nstx_uid(long struct, int value) {
/* 498 */     MemoryUtil.memPutInt(struct + STX_UID, value);
/*     */   } public static void nstx_gid(long struct, int value) {
/* 500 */     MemoryUtil.memPutInt(struct + STX_GID, value);
/*     */   } public static void nstx_mode(long struct, short value) {
/* 502 */     MemoryUtil.memPutShort(struct + STX_MODE, value);
/*     */   } public static void n__spare0(long struct, ShortBuffer value) {
/* 504 */     if (Checks.CHECKS) Checks.checkGT(value, 1); 
/* 505 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + __SPARE0, (value.remaining() * 2));
/*     */   }
/*     */   public static void n__spare0(long struct, int index, short value) {
/* 508 */     MemoryUtil.memPutShort(struct + __SPARE0 + Checks.check(index, 1) * 2L, value);
/*     */   }
/*     */   public static void nstx_ino(long struct, long value) {
/* 511 */     MemoryUtil.memPutLong(struct + STX_INO, value);
/*     */   } public static void nstx_size(long struct, long value) {
/* 513 */     MemoryUtil.memPutLong(struct + STX_SIZE, value);
/*     */   } public static void nstx_blocks(long struct, long value) {
/* 515 */     MemoryUtil.memPutLong(struct + STX_BLOCKS, value);
/*     */   } public static void nstx_attributes_mask(long struct, long value) {
/* 517 */     MemoryUtil.memPutLong(struct + STX_ATTRIBUTES_MASK, value);
/*     */   } public static void nstx_atime(long struct, StatxTimestamp value) {
/* 519 */     MemoryUtil.memCopy(value.address(), struct + STX_ATIME, StatxTimestamp.SIZEOF);
/*     */   } public static void nstx_btime(long struct, StatxTimestamp value) {
/* 521 */     MemoryUtil.memCopy(value.address(), struct + STX_BTIME, StatxTimestamp.SIZEOF);
/*     */   } public static void nstx_ctime(long struct, StatxTimestamp value) {
/* 523 */     MemoryUtil.memCopy(value.address(), struct + STX_CTIME, StatxTimestamp.SIZEOF);
/*     */   } public static void nstx_mtime(long struct, StatxTimestamp value) {
/* 525 */     MemoryUtil.memCopy(value.address(), struct + STX_MTIME, StatxTimestamp.SIZEOF);
/*     */   } public static void nstx_rdev_major(long struct, int value) {
/* 527 */     MemoryUtil.memPutInt(struct + STX_RDEV_MAJOR, value);
/*     */   } public static void nstx_rdev_minor(long struct, int value) {
/* 529 */     MemoryUtil.memPutInt(struct + STX_RDEV_MINOR, value);
/*     */   } public static void nstx_dev_major(long struct, int value) {
/* 531 */     MemoryUtil.memPutInt(struct + STX_DEV_MAJOR, value);
/*     */   } public static void nstx_dev_minor(long struct, int value) {
/* 533 */     MemoryUtil.memPutInt(struct + STX_DEV_MINOR, value);
/*     */   }
/* 535 */   public static void nstx_mnt_id(long struct, long value) { MemoryUtil.memPutLong(struct + STX_MNT_ID, value); } public static void n__spare2(long struct, long value) {
/* 536 */     MemoryUtil.memPutLong(struct + __SPARE2, value);
/*     */   } public static void n__spare3(long struct, LongBuffer value) {
/* 538 */     if (Checks.CHECKS) Checks.checkGT(value, 12); 
/* 539 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + __SPARE3, (value.remaining() * 8));
/*     */   }
/*     */   public static void n__spare3(long struct, int index, long value) {
/* 542 */     MemoryUtil.memPutLong(struct + __SPARE3 + Checks.check(index, 12) * 8L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<Statx, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 550 */     private static final Statx ELEMENT_FACTORY = Statx.create(-1L);
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
/*     */     public Buffer(ByteBuffer container) {
/* 562 */       super(container, container.remaining() / Statx.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 566 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 570 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 575 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 580 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Statx getElementFactory() {
/* 585 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int stx_mask() {
/* 590 */       return Statx.nstx_mask(address());
/*     */     } @NativeType("__u32")
/*     */     public int stx_blksize() {
/* 593 */       return Statx.nstx_blksize(address());
/*     */     } @NativeType("__u64")
/*     */     public long stx_attributes() {
/* 596 */       return Statx.nstx_attributes(address());
/*     */     } @NativeType("__u32")
/*     */     public int stx_nlink() {
/* 599 */       return Statx.nstx_nlink(address());
/*     */     } @NativeType("__u32")
/*     */     public int stx_uid() {
/* 602 */       return Statx.nstx_uid(address());
/*     */     } @NativeType("__u32")
/*     */     public int stx_gid() {
/* 605 */       return Statx.nstx_gid(address());
/*     */     } @NativeType("__u16")
/*     */     public short stx_mode() {
/* 608 */       return Statx.nstx_mode(address());
/*     */     } @NativeType("__u64")
/*     */     public long stx_ino() {
/* 611 */       return Statx.nstx_ino(address());
/*     */     } @NativeType("__u64")
/*     */     public long stx_size() {
/* 614 */       return Statx.nstx_size(address());
/*     */     } @NativeType("__u64")
/*     */     public long stx_blocks() {
/* 617 */       return Statx.nstx_blocks(address());
/*     */     } @NativeType("__u64")
/*     */     public long stx_attributes_mask() {
/* 620 */       return Statx.nstx_attributes_mask(address());
/*     */     } @NativeType("struct statx_timestamp")
/*     */     public StatxTimestamp stx_atime() {
/* 623 */       return Statx.nstx_atime(address());
/*     */     } @NativeType("struct statx_timestamp")
/*     */     public StatxTimestamp stx_btime() {
/* 626 */       return Statx.nstx_btime(address());
/*     */     } @NativeType("struct statx_timestamp")
/*     */     public StatxTimestamp stx_ctime() {
/* 629 */       return Statx.nstx_ctime(address());
/*     */     } @NativeType("struct statx_timestamp")
/*     */     public StatxTimestamp stx_mtime() {
/* 632 */       return Statx.nstx_mtime(address());
/*     */     } @NativeType("__u32")
/*     */     public int stx_rdev_major() {
/* 635 */       return Statx.nstx_rdev_major(address());
/*     */     } @NativeType("__u32")
/*     */     public int stx_rdev_minor() {
/* 638 */       return Statx.nstx_rdev_minor(address());
/*     */     } @NativeType("__u32")
/*     */     public int stx_dev_major() {
/* 641 */       return Statx.nstx_dev_major(address());
/*     */     } @NativeType("__u32")
/*     */     public int stx_dev_minor() {
/* 644 */       return Statx.nstx_dev_minor(address());
/*     */     } @NativeType("__u64")
/*     */     public long stx_mnt_id() {
/* 647 */       return Statx.nstx_mnt_id(address());
/*     */     }
/*     */     public Buffer stx_mask(@NativeType("__u32") int value) {
/* 650 */       Statx.nstx_mask(address(), value); return this;
/*     */     } public Buffer stx_blksize(@NativeType("__u32") int value) {
/* 652 */       Statx.nstx_blksize(address(), value); return this;
/*     */     } public Buffer stx_attributes(@NativeType("__u64") long value) {
/* 654 */       Statx.nstx_attributes(address(), value); return this;
/*     */     } public Buffer stx_nlink(@NativeType("__u32") int value) {
/* 656 */       Statx.nstx_nlink(address(), value); return this;
/*     */     } public Buffer stx_uid(@NativeType("__u32") int value) {
/* 658 */       Statx.nstx_uid(address(), value); return this;
/*     */     } public Buffer stx_gid(@NativeType("__u32") int value) {
/* 660 */       Statx.nstx_gid(address(), value); return this;
/*     */     } public Buffer stx_mode(@NativeType("__u16") short value) {
/* 662 */       Statx.nstx_mode(address(), value); return this;
/*     */     } public Buffer stx_ino(@NativeType("__u64") long value) {
/* 664 */       Statx.nstx_ino(address(), value); return this;
/*     */     } public Buffer stx_size(@NativeType("__u64") long value) {
/* 666 */       Statx.nstx_size(address(), value); return this;
/*     */     } public Buffer stx_blocks(@NativeType("__u64") long value) {
/* 668 */       Statx.nstx_blocks(address(), value); return this;
/*     */     } public Buffer stx_attributes_mask(@NativeType("__u64") long value) {
/* 670 */       Statx.nstx_attributes_mask(address(), value); return this;
/*     */     } public Buffer stx_atime(@NativeType("struct statx_timestamp") StatxTimestamp value) {
/* 672 */       Statx.nstx_atime(address(), value); return this;
/*     */     } public Buffer stx_atime(Consumer<StatxTimestamp> consumer) {
/* 674 */       consumer.accept(stx_atime()); return this;
/*     */     } public Buffer stx_btime(@NativeType("struct statx_timestamp") StatxTimestamp value) {
/* 676 */       Statx.nstx_btime(address(), value); return this;
/*     */     } public Buffer stx_btime(Consumer<StatxTimestamp> consumer) {
/* 678 */       consumer.accept(stx_btime()); return this;
/*     */     } public Buffer stx_ctime(@NativeType("struct statx_timestamp") StatxTimestamp value) {
/* 680 */       Statx.nstx_ctime(address(), value); return this;
/*     */     } public Buffer stx_ctime(Consumer<StatxTimestamp> consumer) {
/* 682 */       consumer.accept(stx_ctime()); return this;
/*     */     } public Buffer stx_mtime(@NativeType("struct statx_timestamp") StatxTimestamp value) {
/* 684 */       Statx.nstx_mtime(address(), value); return this;
/*     */     } public Buffer stx_mtime(Consumer<StatxTimestamp> consumer) {
/* 686 */       consumer.accept(stx_mtime()); return this;
/*     */     } public Buffer stx_rdev_major(@NativeType("__u32") int value) {
/* 688 */       Statx.nstx_rdev_major(address(), value); return this;
/*     */     } public Buffer stx_rdev_minor(@NativeType("__u32") int value) {
/* 690 */       Statx.nstx_rdev_minor(address(), value); return this;
/*     */     } public Buffer stx_dev_major(@NativeType("__u32") int value) {
/* 692 */       Statx.nstx_dev_major(address(), value); return this;
/*     */     } public Buffer stx_dev_minor(@NativeType("__u32") int value) {
/* 694 */       Statx.nstx_dev_minor(address(), value); return this;
/*     */     } public Buffer stx_mnt_id(@NativeType("__u64") long value) {
/* 696 */       Statx.nstx_mnt_id(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\Statx.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */