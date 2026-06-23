/*      */ package org.lwjgl.system.linux.liburing;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.BufferUtils;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeResource;
/*      */ import org.lwjgl.system.NativeType;
/*      */ import org.lwjgl.system.Struct;
/*      */ import org.lwjgl.system.StructBuffer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @NativeType("struct io_uring_sqe")
/*      */ public class IOURingSQE
/*      */   extends Struct<IOURingSQE>
/*      */   implements NativeResource
/*      */ {
/*      */   public static final int SIZEOF;
/*      */   public static final int ALIGNOF;
/*      */   public static final int OPCODE;
/*      */   public static final int FLAGS;
/*      */   public static final int IOPRIO;
/*      */   public static final int FD;
/*      */   public static final int OFF;
/*      */   public static final int ADDR2;
/*      */   public static final int CMD_OP;
/*      */   public static final int __PAD1;
/*      */   public static final int ADDR;
/*      */   public static final int SPLICE_OFF_IN;
/*      */   public static final int LEVEL;
/*      */   public static final int OPTNAME;
/*      */   public static final int LEN;
/*      */   public static final int RW_FLAGS;
/*      */   public static final int FSYNC_FLAGS;
/*      */   public static final int POLL_EVENTS;
/*      */   public static final int POLL32_EVENTS;
/*      */   public static final int SYNC_RANGE_FLAGS;
/*      */   public static final int MSG_FLAGS;
/*      */   public static final int TIMEOUT_FLAGS;
/*      */   public static final int ACCEPT_FLAGS;
/*      */   public static final int CANCEL_FLAGS;
/*      */   public static final int OPEN_FLAGS;
/*      */   public static final int STATX_FLAGS;
/*      */   public static final int FADVISE_ADVICE;
/*      */   public static final int SPLICE_FLAGS;
/*      */   public static final int RENAME_FLAGS;
/*      */   public static final int UNLINK_FLAGS;
/*      */   public static final int HARDLINK_FLAGS;
/*      */   public static final int XATTR_FLAGS;
/*      */   public static final int MSG_RING_FLAGS;
/*      */   public static final int URING_CMD_FLAGS;
/*      */   public static final int WAITID_FLAGS;
/*      */   public static final int FUTEX_FLAGS;
/*      */   public static final int INSTALL_FD_FLAGS;
/*      */   public static final int NOP_FLAGS;
/*      */   public static final int PIPE_FLAGS;
/*      */   public static final int USER_DATA;
/*      */   public static final int BUF_INDEX;
/*      */   public static final int BUF_GROUP;
/*      */   public static final int PERSONALITY;
/*      */   public static final int SPLICE_FD_IN;
/*      */   public static final int FILE_INDEX;
/*      */   public static final int ZCRX_IFQ_IDX;
/*      */   public static final int OPTLEN;
/*      */   public static final int ADDR_LEN;
/*      */   public static final int __PAD3;
/*      */   public static final int ADDR3;
/*      */   public static final int __PAD2;
/*      */   public static final int ATTR_PTR;
/*      */   public static final int ATTR_TYPE_MASK;
/*      */   public static final int OPTVAL;
/*      */   public static final int CMD;
/*      */   
/*      */   static {
/*  165 */     Struct.Layout layout = __struct(new Struct.Member[] { 
/*  166 */           __member(1), 
/*  167 */           __member(1), 
/*  168 */           __member(2), 
/*  169 */           __member(4), 
/*  170 */           (Struct.Member)__union(new Struct.Member[] {
/*  171 */               __member(8), 
/*  172 */               __member(8), 
/*  173 */               (Struct.Member)__struct(new Struct.Member[] {
/*  174 */                   __member(4), 
/*  175 */                   __member(4)
/*      */                 
/*      */                 })
/*  178 */             }), (Struct.Member)__union(new Struct.Member[] {
/*  179 */               __member(8), 
/*  180 */               __member(8), 
/*  181 */               (Struct.Member)__struct(new Struct.Member[] {
/*  182 */                   __member(4), 
/*  183 */                   __member(4)
/*      */                 
/*      */                 })
/*  186 */             }), __member(4), 
/*  187 */           (Struct.Member)__union(new Struct.Member[] { 
/*  188 */               __member(4), 
/*  189 */               __member(4), 
/*  190 */               __member(2), 
/*  191 */               __member(4), 
/*  192 */               __member(4), 
/*  193 */               __member(4), 
/*  194 */               __member(4), 
/*  195 */               __member(4), 
/*  196 */               __member(4), 
/*  197 */               __member(4), 
/*  198 */               __member(4), 
/*  199 */               __member(4), 
/*  200 */               __member(4), 
/*  201 */               __member(4), 
/*  202 */               __member(4), 
/*  203 */               __member(4), 
/*  204 */               __member(4), 
/*  205 */               __member(4), 
/*  206 */               __member(4), 
/*  207 */               __member(4), 
/*  208 */               __member(4), 
/*  209 */               __member(4), 
/*  210 */               __member(4), 
/*  211 */               __member(4)
/*      */             
/*  213 */             }), __member(8), 
/*  214 */           (Struct.Member)__union(new Struct.Member[] {
/*  215 */               __member(2), 
/*  216 */               __member(2)
/*      */             }), 
/*  218 */           __member(2), 
/*  219 */           (Struct.Member)__union(new Struct.Member[] {
/*  220 */               __member(4), 
/*  221 */               __member(4), 
/*  222 */               __member(4), 
/*  223 */               __member(4), 
/*  224 */               (Struct.Member)__struct(new Struct.Member[] {
/*  225 */                   __member(2), 
/*  226 */                   __array(2, 1)
/*      */                 
/*      */                 })
/*  229 */             }), (Struct.Member)__union(new Struct.Member[] {
/*  230 */               (Struct.Member)__struct(new Struct.Member[] {
/*  231 */                   __member(8), 
/*  232 */                   __array(8, 1)
/*      */                 
/*  234 */                 }), (Struct.Member)__struct(new Struct.Member[] {
/*  235 */                   __member(8), 
/*  236 */                   __member(8)
/*      */                 
/*  238 */                 }), __member(8), 
/*  239 */               __array(1, 0)
/*      */             }) });
/*      */ 
/*      */     
/*  243 */     SIZEOF = layout.getSize();
/*  244 */     ALIGNOF = layout.getAlignment();
/*      */     
/*  246 */     OPCODE = layout.offsetof(0);
/*  247 */     FLAGS = layout.offsetof(1);
/*  248 */     IOPRIO = layout.offsetof(2);
/*  249 */     FD = layout.offsetof(3);
/*  250 */     OFF = layout.offsetof(5);
/*  251 */     ADDR2 = layout.offsetof(6);
/*  252 */     CMD_OP = layout.offsetof(8);
/*  253 */     __PAD1 = layout.offsetof(9);
/*  254 */     ADDR = layout.offsetof(11);
/*  255 */     SPLICE_OFF_IN = layout.offsetof(12);
/*  256 */     LEVEL = layout.offsetof(14);
/*  257 */     OPTNAME = layout.offsetof(15);
/*  258 */     LEN = layout.offsetof(16);
/*  259 */     RW_FLAGS = layout.offsetof(18);
/*  260 */     FSYNC_FLAGS = layout.offsetof(19);
/*  261 */     POLL_EVENTS = layout.offsetof(20);
/*  262 */     POLL32_EVENTS = layout.offsetof(21);
/*  263 */     SYNC_RANGE_FLAGS = layout.offsetof(22);
/*  264 */     MSG_FLAGS = layout.offsetof(23);
/*  265 */     TIMEOUT_FLAGS = layout.offsetof(24);
/*  266 */     ACCEPT_FLAGS = layout.offsetof(25);
/*  267 */     CANCEL_FLAGS = layout.offsetof(26);
/*  268 */     OPEN_FLAGS = layout.offsetof(27);
/*  269 */     STATX_FLAGS = layout.offsetof(28);
/*  270 */     FADVISE_ADVICE = layout.offsetof(29);
/*  271 */     SPLICE_FLAGS = layout.offsetof(30);
/*  272 */     RENAME_FLAGS = layout.offsetof(31);
/*  273 */     UNLINK_FLAGS = layout.offsetof(32);
/*  274 */     HARDLINK_FLAGS = layout.offsetof(33);
/*  275 */     XATTR_FLAGS = layout.offsetof(34);
/*  276 */     MSG_RING_FLAGS = layout.offsetof(35);
/*  277 */     URING_CMD_FLAGS = layout.offsetof(36);
/*  278 */     WAITID_FLAGS = layout.offsetof(37);
/*  279 */     FUTEX_FLAGS = layout.offsetof(38);
/*  280 */     INSTALL_FD_FLAGS = layout.offsetof(39);
/*  281 */     NOP_FLAGS = layout.offsetof(40);
/*  282 */     PIPE_FLAGS = layout.offsetof(41);
/*  283 */     USER_DATA = layout.offsetof(42);
/*  284 */     BUF_INDEX = layout.offsetof(44);
/*  285 */     BUF_GROUP = layout.offsetof(45);
/*  286 */     PERSONALITY = layout.offsetof(46);
/*  287 */     SPLICE_FD_IN = layout.offsetof(48);
/*  288 */     FILE_INDEX = layout.offsetof(49);
/*  289 */     ZCRX_IFQ_IDX = layout.offsetof(50);
/*  290 */     OPTLEN = layout.offsetof(51);
/*  291 */     ADDR_LEN = layout.offsetof(53);
/*  292 */     __PAD3 = layout.offsetof(54);
/*  293 */     ADDR3 = layout.offsetof(57);
/*  294 */     __PAD2 = layout.offsetof(58);
/*  295 */     ATTR_PTR = layout.offsetof(60);
/*  296 */     ATTR_TYPE_MASK = layout.offsetof(61);
/*  297 */     OPTVAL = layout.offsetof(62);
/*  298 */     CMD = layout.offsetof(63);
/*      */   }
/*      */   
/*      */   protected IOURingSQE(long address, ByteBuffer container) {
/*  302 */     super(address, container);
/*      */   }
/*      */ 
/*      */   
/*      */   protected IOURingSQE create(long address, ByteBuffer container) {
/*  307 */     return new IOURingSQE(address, container);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IOURingSQE(ByteBuffer container) {
/*  317 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*      */   }
/*      */   
/*      */   public int sizeof() {
/*  321 */     return SIZEOF;
/*      */   }
/*      */   @NativeType("__u8")
/*      */   public byte opcode() {
/*  325 */     return nopcode(address());
/*      */   } @NativeType("__u8")
/*      */   public byte flags() {
/*  328 */     return nflags(address());
/*      */   } @NativeType("__u16")
/*      */   public short ioprio() {
/*  331 */     return nioprio(address());
/*      */   } @NativeType("__s32")
/*      */   public int fd() {
/*  334 */     return nfd(address());
/*      */   } @NativeType("__u64")
/*      */   public long off() {
/*  337 */     return noff(address());
/*      */   } @NativeType("__u64")
/*      */   public long addr2() {
/*  340 */     return naddr2(address());
/*      */   } @NativeType("__u32")
/*      */   public int cmd_op() {
/*  343 */     return ncmd_op(address());
/*      */   } @NativeType("__u32")
/*      */   public int __pad1() {
/*  346 */     return n__pad1(address());
/*      */   } @NativeType("__u64")
/*      */   public long addr() {
/*  349 */     return naddr(address());
/*      */   } @NativeType("__u64")
/*      */   public long splice_off_in() {
/*  352 */     return nsplice_off_in(address());
/*      */   } @NativeType("__u32")
/*      */   public int level() {
/*  355 */     return nlevel(address());
/*      */   } @NativeType("__u32")
/*      */   public int optname() {
/*  358 */     return noptname(address());
/*      */   } @NativeType("__u32")
/*      */   public int len() {
/*  361 */     return nlen(address());
/*      */   } @NativeType("__kernel_rwf_t")
/*      */   public int rw_flags() {
/*  364 */     return nrw_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int fsync_flags() {
/*  367 */     return nfsync_flags(address());
/*      */   } @NativeType("__u16")
/*      */   public short poll_events() {
/*  370 */     return npoll_events(address());
/*      */   } @NativeType("__u32")
/*      */   public int poll32_events() {
/*  373 */     return npoll32_events(address());
/*      */   } @NativeType("__u32")
/*      */   public int sync_range_flags() {
/*  376 */     return nsync_range_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int msg_flags() {
/*  379 */     return nmsg_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int timeout_flags() {
/*  382 */     return ntimeout_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int accept_flags() {
/*  385 */     return naccept_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int cancel_flags() {
/*  388 */     return ncancel_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int open_flags() {
/*  391 */     return nopen_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int statx_flags() {
/*  394 */     return nstatx_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int fadvise_advice() {
/*  397 */     return nfadvise_advice(address());
/*      */   } @NativeType("__u32")
/*      */   public int splice_flags() {
/*  400 */     return nsplice_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int rename_flags() {
/*  403 */     return nrename_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int unlink_flags() {
/*  406 */     return nunlink_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int hardlink_flags() {
/*  409 */     return nhardlink_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int xattr_flags() {
/*  412 */     return nxattr_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int msg_ring_flags() {
/*  415 */     return nmsg_ring_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int uring_cmd_flags() {
/*  418 */     return nuring_cmd_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int waitid_flags() {
/*  421 */     return nwaitid_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int futex_flags() {
/*  424 */     return nfutex_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int install_fd_flags() {
/*  427 */     return ninstall_fd_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int nop_flags() {
/*  430 */     return nnop_flags(address());
/*      */   } @NativeType("__u32")
/*      */   public int pipe_flags() {
/*  433 */     return npipe_flags(address());
/*      */   } @NativeType("__u64")
/*      */   public long user_data() {
/*  436 */     return nuser_data(address());
/*      */   } @NativeType("__u16")
/*      */   public short buf_index() {
/*  439 */     return nbuf_index(address());
/*      */   } @NativeType("__u16")
/*      */   public short buf_group() {
/*  442 */     return nbuf_group(address());
/*      */   } @NativeType("__u16")
/*      */   public short personality() {
/*  445 */     return npersonality(address());
/*      */   } @NativeType("__s32")
/*      */   public int splice_fd_in() {
/*  448 */     return nsplice_fd_in(address());
/*      */   } @NativeType("__u32")
/*      */   public int file_index() {
/*  451 */     return nfile_index(address());
/*      */   } @NativeType("__u32")
/*      */   public int zcrx_ifq_idx() {
/*  454 */     return nzcrx_ifq_idx(address());
/*      */   } @NativeType("__u32")
/*      */   public int optlen() {
/*  457 */     return noptlen(address());
/*      */   } @NativeType("__u16")
/*      */   public short addr_len() {
/*  460 */     return naddr_len(address());
/*      */   } @NativeType("__u16[1]")
/*      */   public ShortBuffer __pad3() {
/*  463 */     return n__pad3(address());
/*      */   } @NativeType("__u16")
/*      */   public short __pad3(int index) {
/*  466 */     return n__pad3(address(), index);
/*      */   } @NativeType("__u64")
/*      */   public long addr3() {
/*  469 */     return naddr3(address());
/*      */   } @NativeType("__u64[1]")
/*      */   public LongBuffer __pad2() {
/*  472 */     return n__pad2(address());
/*      */   } @NativeType("__u64")
/*      */   public long __pad2(int index) {
/*  475 */     return n__pad2(address(), index);
/*      */   } @NativeType("__u64")
/*      */   public long attr_ptr() {
/*  478 */     return nattr_ptr(address());
/*      */   } @NativeType("__u64")
/*      */   public long attr_type_mask() {
/*  481 */     return nattr_type_mask(address());
/*      */   } @NativeType("__u64")
/*      */   public long optval() {
/*  484 */     return noptval(address());
/*      */   } @NativeType("__u8[0]")
/*      */   public ByteBuffer cmd() {
/*  487 */     return ncmd(address());
/*      */   } @NativeType("__u8")
/*      */   public byte cmd(int index) {
/*  490 */     return ncmd(address(), index);
/*      */   }
/*      */   public IOURingSQE opcode(@NativeType("__u8") byte value) {
/*  493 */     nopcode(address(), value); return this;
/*      */   } public IOURingSQE flags(@NativeType("__u8") byte value) {
/*  495 */     nflags(address(), value); return this;
/*      */   } public IOURingSQE ioprio(@NativeType("__u16") short value) {
/*  497 */     nioprio(address(), value); return this;
/*      */   } public IOURingSQE fd(@NativeType("__s32") int value) {
/*  499 */     nfd(address(), value); return this;
/*      */   } public IOURingSQE off(@NativeType("__u64") long value) {
/*  501 */     noff(address(), value); return this;
/*      */   } public IOURingSQE addr2(@NativeType("__u64") long value) {
/*  503 */     naddr2(address(), value); return this;
/*      */   } public IOURingSQE cmd_op(@NativeType("__u32") int value) {
/*  505 */     ncmd_op(address(), value); return this;
/*      */   } public IOURingSQE __pad1(@NativeType("__u32") int value) {
/*  507 */     n__pad1(address(), value); return this;
/*      */   } public IOURingSQE addr(@NativeType("__u64") long value) {
/*  509 */     naddr(address(), value); return this;
/*      */   } public IOURingSQE splice_off_in(@NativeType("__u64") long value) {
/*  511 */     nsplice_off_in(address(), value); return this;
/*      */   } public IOURingSQE level(@NativeType("__u32") int value) {
/*  513 */     nlevel(address(), value); return this;
/*      */   } public IOURingSQE optname(@NativeType("__u32") int value) {
/*  515 */     noptname(address(), value); return this;
/*      */   } public IOURingSQE len(@NativeType("__u32") int value) {
/*  517 */     nlen(address(), value); return this;
/*      */   } public IOURingSQE rw_flags(@NativeType("__kernel_rwf_t") int value) {
/*  519 */     nrw_flags(address(), value); return this;
/*      */   } public IOURingSQE fsync_flags(@NativeType("__u32") int value) {
/*  521 */     nfsync_flags(address(), value); return this;
/*      */   } public IOURingSQE poll_events(@NativeType("__u16") short value) {
/*  523 */     npoll_events(address(), value); return this;
/*      */   } public IOURingSQE poll32_events(@NativeType("__u32") int value) {
/*  525 */     npoll32_events(address(), value); return this;
/*      */   } public IOURingSQE sync_range_flags(@NativeType("__u32") int value) {
/*  527 */     nsync_range_flags(address(), value); return this;
/*      */   } public IOURingSQE msg_flags(@NativeType("__u32") int value) {
/*  529 */     nmsg_flags(address(), value); return this;
/*      */   } public IOURingSQE timeout_flags(@NativeType("__u32") int value) {
/*  531 */     ntimeout_flags(address(), value); return this;
/*      */   } public IOURingSQE accept_flags(@NativeType("__u32") int value) {
/*  533 */     naccept_flags(address(), value); return this;
/*      */   } public IOURingSQE cancel_flags(@NativeType("__u32") int value) {
/*  535 */     ncancel_flags(address(), value); return this;
/*      */   } public IOURingSQE open_flags(@NativeType("__u32") int value) {
/*  537 */     nopen_flags(address(), value); return this;
/*      */   } public IOURingSQE statx_flags(@NativeType("__u32") int value) {
/*  539 */     nstatx_flags(address(), value); return this;
/*      */   } public IOURingSQE fadvise_advice(@NativeType("__u32") int value) {
/*  541 */     nfadvise_advice(address(), value); return this;
/*      */   } public IOURingSQE splice_flags(@NativeType("__u32") int value) {
/*  543 */     nsplice_flags(address(), value); return this;
/*      */   } public IOURingSQE rename_flags(@NativeType("__u32") int value) {
/*  545 */     nrename_flags(address(), value); return this;
/*      */   } public IOURingSQE unlink_flags(@NativeType("__u32") int value) {
/*  547 */     nunlink_flags(address(), value); return this;
/*      */   } public IOURingSQE hardlink_flags(@NativeType("__u32") int value) {
/*  549 */     nhardlink_flags(address(), value); return this;
/*      */   } public IOURingSQE xattr_flags(@NativeType("__u32") int value) {
/*  551 */     nxattr_flags(address(), value); return this;
/*      */   } public IOURingSQE msg_ring_flags(@NativeType("__u32") int value) {
/*  553 */     nmsg_ring_flags(address(), value); return this;
/*      */   } public IOURingSQE uring_cmd_flags(@NativeType("__u32") int value) {
/*  555 */     nuring_cmd_flags(address(), value); return this;
/*      */   } public IOURingSQE waitid_flags(@NativeType("__u32") int value) {
/*  557 */     nwaitid_flags(address(), value); return this;
/*      */   } public IOURingSQE futex_flags(@NativeType("__u32") int value) {
/*  559 */     nfutex_flags(address(), value); return this;
/*      */   } public IOURingSQE install_fd_flags(@NativeType("__u32") int value) {
/*  561 */     ninstall_fd_flags(address(), value); return this;
/*      */   } public IOURingSQE nop_flags(@NativeType("__u32") int value) {
/*  563 */     nnop_flags(address(), value); return this;
/*      */   } public IOURingSQE pipe_flags(@NativeType("__u32") int value) {
/*  565 */     npipe_flags(address(), value); return this;
/*      */   } public IOURingSQE user_data(@NativeType("__u64") long value) {
/*  567 */     nuser_data(address(), value); return this;
/*      */   } public IOURingSQE buf_index(@NativeType("__u16") short value) {
/*  569 */     nbuf_index(address(), value); return this;
/*      */   } public IOURingSQE buf_group(@NativeType("__u16") short value) {
/*  571 */     nbuf_group(address(), value); return this;
/*      */   } public IOURingSQE personality(@NativeType("__u16") short value) {
/*  573 */     npersonality(address(), value); return this;
/*      */   } public IOURingSQE splice_fd_in(@NativeType("__s32") int value) {
/*  575 */     nsplice_fd_in(address(), value); return this;
/*      */   } public IOURingSQE file_index(@NativeType("__u32") int value) {
/*  577 */     nfile_index(address(), value); return this;
/*      */   } public IOURingSQE zcrx_ifq_idx(@NativeType("__u32") int value) {
/*  579 */     nzcrx_ifq_idx(address(), value); return this;
/*      */   } public IOURingSQE optlen(@NativeType("__u32") int value) {
/*  581 */     noptlen(address(), value); return this;
/*      */   } public IOURingSQE addr_len(@NativeType("__u16") short value) {
/*  583 */     naddr_len(address(), value); return this;
/*      */   } public IOURingSQE __pad3(@NativeType("__u16[1]") ShortBuffer value) {
/*  585 */     n__pad3(address(), value); return this;
/*      */   } public IOURingSQE __pad3(int index, @NativeType("__u16") short value) {
/*  587 */     n__pad3(address(), index, value); return this;
/*      */   } public IOURingSQE addr3(@NativeType("__u64") long value) {
/*  589 */     naddr3(address(), value); return this;
/*      */   } public IOURingSQE __pad2(@NativeType("__u64[1]") LongBuffer value) {
/*  591 */     n__pad2(address(), value); return this;
/*      */   } public IOURingSQE __pad2(int index, @NativeType("__u64") long value) {
/*  593 */     n__pad2(address(), index, value); return this;
/*      */   } public IOURingSQE attr_ptr(@NativeType("__u64") long value) {
/*  595 */     nattr_ptr(address(), value); return this;
/*      */   } public IOURingSQE attr_type_mask(@NativeType("__u64") long value) {
/*  597 */     nattr_type_mask(address(), value); return this;
/*      */   } public IOURingSQE optval(@NativeType("__u64") long value) {
/*  599 */     noptval(address(), value); return this;
/*      */   } public IOURingSQE cmd(@NativeType("__u8[0]") ByteBuffer value) {
/*  601 */     ncmd(address(), value); return this;
/*      */   } public IOURingSQE cmd(int index, @NativeType("__u8") byte value) {
/*  603 */     ncmd(address(), index, value); return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IOURingSQE set(IOURingSQE src) {
/*  613 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/*  614 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static IOURingSQE malloc() {
/*  621 */     return new IOURingSQE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*      */   }
/*      */ 
/*      */   
/*      */   public static IOURingSQE calloc() {
/*  626 */     return new IOURingSQE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*      */   }
/*      */ 
/*      */   
/*      */   public static IOURingSQE create() {
/*  631 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/*  632 */     return new IOURingSQE(MemoryUtil.memAddress(container), container);
/*      */   }
/*      */ 
/*      */   
/*      */   public static IOURingSQE create(long address) {
/*  637 */     return new IOURingSQE(address, null);
/*      */   }
/*      */ 
/*      */   
/*      */   public static IOURingSQE createSafe(long address) {
/*  642 */     return (address == 0L) ? null : new IOURingSQE(address, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Buffer malloc(int capacity) {
/*  651 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Buffer calloc(int capacity) {
/*  660 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Buffer create(int capacity) {
/*  669 */     ByteBuffer container = __create(capacity, SIZEOF);
/*  670 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Buffer create(long address, int capacity) {
/*  680 */     return new Buffer(address, capacity);
/*      */   }
/*      */ 
/*      */   
/*      */   public static Buffer createSafe(long address, int capacity) {
/*  685 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static IOURingSQE malloc(MemoryStack stack) {
/*  694 */     return new IOURingSQE(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static IOURingSQE calloc(MemoryStack stack) {
/*  703 */     return new IOURingSQE(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Buffer malloc(int capacity, MemoryStack stack) {
/*  713 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Buffer calloc(int capacity, MemoryStack stack) {
/*  723 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte nopcode(long struct) {
/*  729 */     return MemoryUtil.memGetByte(struct + OPCODE);
/*      */   } public static byte nflags(long struct) {
/*  731 */     return MemoryUtil.memGetByte(struct + FLAGS);
/*      */   } public static short nioprio(long struct) {
/*  733 */     return MemoryUtil.memGetShort(struct + IOPRIO);
/*      */   } public static int nfd(long struct) {
/*  735 */     return MemoryUtil.memGetInt(struct + FD);
/*      */   } public static long noff(long struct) {
/*  737 */     return MemoryUtil.memGetLong(struct + OFF);
/*      */   } public static long naddr2(long struct) {
/*  739 */     return MemoryUtil.memGetLong(struct + ADDR2);
/*      */   }
/*  741 */   public static int ncmd_op(long struct) { return MemoryUtil.memGetInt(struct + CMD_OP); } public static int n__pad1(long struct) {
/*  742 */     return MemoryUtil.memGetInt(struct + __PAD1);
/*      */   } public static long naddr(long struct) {
/*  744 */     return MemoryUtil.memGetLong(struct + ADDR);
/*      */   } public static long nsplice_off_in(long struct) {
/*  746 */     return MemoryUtil.memGetLong(struct + SPLICE_OFF_IN);
/*      */   } public static int nlevel(long struct) {
/*  748 */     return MemoryUtil.memGetInt(struct + LEVEL);
/*      */   } public static int noptname(long struct) {
/*  750 */     return MemoryUtil.memGetInt(struct + OPTNAME);
/*      */   } public static int nlen(long struct) {
/*  752 */     return MemoryUtil.memGetInt(struct + LEN);
/*      */   } public static int nrw_flags(long struct) {
/*  754 */     return MemoryUtil.memGetInt(struct + RW_FLAGS);
/*      */   } public static int nfsync_flags(long struct) {
/*  756 */     return MemoryUtil.memGetInt(struct + FSYNC_FLAGS);
/*      */   } public static short npoll_events(long struct) {
/*  758 */     return MemoryUtil.memGetShort(struct + POLL_EVENTS);
/*      */   } public static int npoll32_events(long struct) {
/*  760 */     return MemoryUtil.memGetInt(struct + POLL32_EVENTS);
/*      */   } public static int nsync_range_flags(long struct) {
/*  762 */     return MemoryUtil.memGetInt(struct + SYNC_RANGE_FLAGS);
/*      */   } public static int nmsg_flags(long struct) {
/*  764 */     return MemoryUtil.memGetInt(struct + MSG_FLAGS);
/*      */   } public static int ntimeout_flags(long struct) {
/*  766 */     return MemoryUtil.memGetInt(struct + TIMEOUT_FLAGS);
/*      */   } public static int naccept_flags(long struct) {
/*  768 */     return MemoryUtil.memGetInt(struct + ACCEPT_FLAGS);
/*      */   } public static int ncancel_flags(long struct) {
/*  770 */     return MemoryUtil.memGetInt(struct + CANCEL_FLAGS);
/*      */   } public static int nopen_flags(long struct) {
/*  772 */     return MemoryUtil.memGetInt(struct + OPEN_FLAGS);
/*      */   } public static int nstatx_flags(long struct) {
/*  774 */     return MemoryUtil.memGetInt(struct + STATX_FLAGS);
/*      */   } public static int nfadvise_advice(long struct) {
/*  776 */     return MemoryUtil.memGetInt(struct + FADVISE_ADVICE);
/*      */   } public static int nsplice_flags(long struct) {
/*  778 */     return MemoryUtil.memGetInt(struct + SPLICE_FLAGS);
/*      */   } public static int nrename_flags(long struct) {
/*  780 */     return MemoryUtil.memGetInt(struct + RENAME_FLAGS);
/*      */   } public static int nunlink_flags(long struct) {
/*  782 */     return MemoryUtil.memGetInt(struct + UNLINK_FLAGS);
/*      */   } public static int nhardlink_flags(long struct) {
/*  784 */     return MemoryUtil.memGetInt(struct + HARDLINK_FLAGS);
/*      */   } public static int nxattr_flags(long struct) {
/*  786 */     return MemoryUtil.memGetInt(struct + XATTR_FLAGS);
/*      */   } public static int nmsg_ring_flags(long struct) {
/*  788 */     return MemoryUtil.memGetInt(struct + MSG_RING_FLAGS);
/*      */   } public static int nuring_cmd_flags(long struct) {
/*  790 */     return MemoryUtil.memGetInt(struct + URING_CMD_FLAGS);
/*      */   } public static int nwaitid_flags(long struct) {
/*  792 */     return MemoryUtil.memGetInt(struct + WAITID_FLAGS);
/*      */   } public static int nfutex_flags(long struct) {
/*  794 */     return MemoryUtil.memGetInt(struct + FUTEX_FLAGS);
/*      */   } public static int ninstall_fd_flags(long struct) {
/*  796 */     return MemoryUtil.memGetInt(struct + INSTALL_FD_FLAGS);
/*      */   } public static int nnop_flags(long struct) {
/*  798 */     return MemoryUtil.memGetInt(struct + NOP_FLAGS);
/*      */   } public static int npipe_flags(long struct) {
/*  800 */     return MemoryUtil.memGetInt(struct + PIPE_FLAGS);
/*      */   } public static long nuser_data(long struct) {
/*  802 */     return MemoryUtil.memGetLong(struct + USER_DATA);
/*      */   } public static short nbuf_index(long struct) {
/*  804 */     return MemoryUtil.memGetShort(struct + BUF_INDEX);
/*      */   } public static short nbuf_group(long struct) {
/*  806 */     return MemoryUtil.memGetShort(struct + BUF_GROUP);
/*      */   } public static short npersonality(long struct) {
/*  808 */     return MemoryUtil.memGetShort(struct + PERSONALITY);
/*      */   } public static int nsplice_fd_in(long struct) {
/*  810 */     return MemoryUtil.memGetInt(struct + SPLICE_FD_IN);
/*      */   } public static int nfile_index(long struct) {
/*  812 */     return MemoryUtil.memGetInt(struct + FILE_INDEX);
/*      */   } public static int nzcrx_ifq_idx(long struct) {
/*  814 */     return MemoryUtil.memGetInt(struct + ZCRX_IFQ_IDX);
/*      */   } public static int noptlen(long struct) {
/*  816 */     return MemoryUtil.memGetInt(struct + OPTLEN);
/*      */   }
/*  818 */   public static short naddr_len(long struct) { return MemoryUtil.memGetShort(struct + ADDR_LEN); } public static ShortBuffer n__pad3(long struct) {
/*  819 */     return MemoryUtil.memShortBuffer(struct + __PAD3, 1);
/*      */   } public static short n__pad3(long struct, int index) {
/*  821 */     return MemoryUtil.memGetShort(struct + __PAD3 + Checks.check(index, 1) * 2L);
/*      */   }
/*      */   
/*  824 */   public static long naddr3(long struct) { return MemoryUtil.memGetLong(struct + ADDR3); } public static LongBuffer n__pad2(long struct) {
/*  825 */     return MemoryUtil.memLongBuffer(struct + __PAD2, 1);
/*      */   } public static long n__pad2(long struct, int index) {
/*  827 */     return MemoryUtil.memGetLong(struct + __PAD2 + Checks.check(index, 1) * 8L);
/*      */   }
/*      */   public static long nattr_ptr(long struct) {
/*  830 */     return MemoryUtil.memGetLong(struct + ATTR_PTR);
/*      */   } public static long nattr_type_mask(long struct) {
/*  832 */     return MemoryUtil.memGetLong(struct + ATTR_TYPE_MASK);
/*      */   } public static long noptval(long struct) {
/*  834 */     return MemoryUtil.memGetLong(struct + OPTVAL);
/*      */   } public static ByteBuffer ncmd(long struct) {
/*  836 */     return MemoryUtil.memByteBuffer(struct + CMD, 0);
/*      */   }
/*      */   public static byte ncmd(long struct, int index) {
/*  839 */     return MemoryUtil.memGetByte(struct + CMD + Checks.check(index, 0) * 1L);
/*      */   }
/*      */   
/*      */   public static void nopcode(long struct, byte value) {
/*  843 */     MemoryUtil.memPutByte(struct + OPCODE, value);
/*      */   } public static void nflags(long struct, byte value) {
/*  845 */     MemoryUtil.memPutByte(struct + FLAGS, value);
/*      */   } public static void nioprio(long struct, short value) {
/*  847 */     MemoryUtil.memPutShort(struct + IOPRIO, value);
/*      */   } public static void nfd(long struct, int value) {
/*  849 */     MemoryUtil.memPutInt(struct + FD, value);
/*      */   } public static void noff(long struct, long value) {
/*  851 */     MemoryUtil.memPutLong(struct + OFF, value);
/*      */   } public static void naddr2(long struct, long value) {
/*  853 */     MemoryUtil.memPutLong(struct + ADDR2, value);
/*      */   }
/*  855 */   public static void ncmd_op(long struct, int value) { MemoryUtil.memPutInt(struct + CMD_OP, value); } public static void n__pad1(long struct, int value) {
/*  856 */     MemoryUtil.memPutInt(struct + __PAD1, value);
/*      */   } public static void naddr(long struct, long value) {
/*  858 */     MemoryUtil.memPutLong(struct + ADDR, value);
/*      */   } public static void nsplice_off_in(long struct, long value) {
/*  860 */     MemoryUtil.memPutLong(struct + SPLICE_OFF_IN, value);
/*      */   } public static void nlevel(long struct, int value) {
/*  862 */     MemoryUtil.memPutInt(struct + LEVEL, value);
/*      */   } public static void noptname(long struct, int value) {
/*  864 */     MemoryUtil.memPutInt(struct + OPTNAME, value);
/*      */   } public static void nlen(long struct, int value) {
/*  866 */     MemoryUtil.memPutInt(struct + LEN, value);
/*      */   } public static void nrw_flags(long struct, int value) {
/*  868 */     MemoryUtil.memPutInt(struct + RW_FLAGS, value);
/*      */   } public static void nfsync_flags(long struct, int value) {
/*  870 */     MemoryUtil.memPutInt(struct + FSYNC_FLAGS, value);
/*      */   } public static void npoll_events(long struct, short value) {
/*  872 */     MemoryUtil.memPutShort(struct + POLL_EVENTS, value);
/*      */   } public static void npoll32_events(long struct, int value) {
/*  874 */     MemoryUtil.memPutInt(struct + POLL32_EVENTS, value);
/*      */   } public static void nsync_range_flags(long struct, int value) {
/*  876 */     MemoryUtil.memPutInt(struct + SYNC_RANGE_FLAGS, value);
/*      */   } public static void nmsg_flags(long struct, int value) {
/*  878 */     MemoryUtil.memPutInt(struct + MSG_FLAGS, value);
/*      */   } public static void ntimeout_flags(long struct, int value) {
/*  880 */     MemoryUtil.memPutInt(struct + TIMEOUT_FLAGS, value);
/*      */   } public static void naccept_flags(long struct, int value) {
/*  882 */     MemoryUtil.memPutInt(struct + ACCEPT_FLAGS, value);
/*      */   } public static void ncancel_flags(long struct, int value) {
/*  884 */     MemoryUtil.memPutInt(struct + CANCEL_FLAGS, value);
/*      */   } public static void nopen_flags(long struct, int value) {
/*  886 */     MemoryUtil.memPutInt(struct + OPEN_FLAGS, value);
/*      */   } public static void nstatx_flags(long struct, int value) {
/*  888 */     MemoryUtil.memPutInt(struct + STATX_FLAGS, value);
/*      */   } public static void nfadvise_advice(long struct, int value) {
/*  890 */     MemoryUtil.memPutInt(struct + FADVISE_ADVICE, value);
/*      */   } public static void nsplice_flags(long struct, int value) {
/*  892 */     MemoryUtil.memPutInt(struct + SPLICE_FLAGS, value);
/*      */   } public static void nrename_flags(long struct, int value) {
/*  894 */     MemoryUtil.memPutInt(struct + RENAME_FLAGS, value);
/*      */   } public static void nunlink_flags(long struct, int value) {
/*  896 */     MemoryUtil.memPutInt(struct + UNLINK_FLAGS, value);
/*      */   } public static void nhardlink_flags(long struct, int value) {
/*  898 */     MemoryUtil.memPutInt(struct + HARDLINK_FLAGS, value);
/*      */   } public static void nxattr_flags(long struct, int value) {
/*  900 */     MemoryUtil.memPutInt(struct + XATTR_FLAGS, value);
/*      */   } public static void nmsg_ring_flags(long struct, int value) {
/*  902 */     MemoryUtil.memPutInt(struct + MSG_RING_FLAGS, value);
/*      */   } public static void nuring_cmd_flags(long struct, int value) {
/*  904 */     MemoryUtil.memPutInt(struct + URING_CMD_FLAGS, value);
/*      */   } public static void nwaitid_flags(long struct, int value) {
/*  906 */     MemoryUtil.memPutInt(struct + WAITID_FLAGS, value);
/*      */   } public static void nfutex_flags(long struct, int value) {
/*  908 */     MemoryUtil.memPutInt(struct + FUTEX_FLAGS, value);
/*      */   } public static void ninstall_fd_flags(long struct, int value) {
/*  910 */     MemoryUtil.memPutInt(struct + INSTALL_FD_FLAGS, value);
/*      */   } public static void nnop_flags(long struct, int value) {
/*  912 */     MemoryUtil.memPutInt(struct + NOP_FLAGS, value);
/*      */   } public static void npipe_flags(long struct, int value) {
/*  914 */     MemoryUtil.memPutInt(struct + PIPE_FLAGS, value);
/*      */   } public static void nuser_data(long struct, long value) {
/*  916 */     MemoryUtil.memPutLong(struct + USER_DATA, value);
/*      */   } public static void nbuf_index(long struct, short value) {
/*  918 */     MemoryUtil.memPutShort(struct + BUF_INDEX, value);
/*      */   } public static void nbuf_group(long struct, short value) {
/*  920 */     MemoryUtil.memPutShort(struct + BUF_GROUP, value);
/*      */   } public static void npersonality(long struct, short value) {
/*  922 */     MemoryUtil.memPutShort(struct + PERSONALITY, value);
/*      */   } public static void nsplice_fd_in(long struct, int value) {
/*  924 */     MemoryUtil.memPutInt(struct + SPLICE_FD_IN, value);
/*      */   } public static void nfile_index(long struct, int value) {
/*  926 */     MemoryUtil.memPutInt(struct + FILE_INDEX, value);
/*      */   } public static void nzcrx_ifq_idx(long struct, int value) {
/*  928 */     MemoryUtil.memPutInt(struct + ZCRX_IFQ_IDX, value);
/*      */   } public static void noptlen(long struct, int value) {
/*  930 */     MemoryUtil.memPutInt(struct + OPTLEN, value);
/*      */   } public static void naddr_len(long struct, short value) {
/*  932 */     MemoryUtil.memPutShort(struct + ADDR_LEN, value);
/*      */   } public static void n__pad3(long struct, ShortBuffer value) {
/*  934 */     if (Checks.CHECKS) Checks.checkGT(value, 1); 
/*  935 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + __PAD3, (value.remaining() * 2));
/*      */   }
/*      */   public static void n__pad3(long struct, int index, short value) {
/*  938 */     MemoryUtil.memPutShort(struct + __PAD3 + Checks.check(index, 1) * 2L, value);
/*      */   }
/*      */   public static void naddr3(long struct, long value) {
/*  941 */     MemoryUtil.memPutLong(struct + ADDR3, value);
/*      */   } public static void n__pad2(long struct, LongBuffer value) {
/*  943 */     if (Checks.CHECKS) Checks.checkGT(value, 1); 
/*  944 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + __PAD2, (value.remaining() * 8));
/*      */   }
/*      */   public static void n__pad2(long struct, int index, long value) {
/*  947 */     MemoryUtil.memPutLong(struct + __PAD2 + Checks.check(index, 1) * 8L, value);
/*      */   }
/*      */   public static void nattr_ptr(long struct, long value) {
/*  950 */     MemoryUtil.memPutLong(struct + ATTR_PTR, value);
/*      */   } public static void nattr_type_mask(long struct, long value) {
/*  952 */     MemoryUtil.memPutLong(struct + ATTR_TYPE_MASK, value);
/*      */   } public static void noptval(long struct, long value) {
/*  954 */     MemoryUtil.memPutLong(struct + OPTVAL, value);
/*      */   }
/*      */   public static void ncmd(long struct, ByteBuffer value) {
/*  957 */     if (Checks.CHECKS) Checks.checkGT(value, 0); 
/*  958 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + CMD, (value.remaining() * 1));
/*      */   }
/*      */   
/*      */   public static void ncmd(long struct, int index, byte value) {
/*  962 */     MemoryUtil.memPutByte(struct + CMD + Checks.check(index, 0) * 1L, value);
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Buffer
/*      */     extends StructBuffer<IOURingSQE, Buffer>
/*      */     implements NativeResource
/*      */   {
/*  970 */     private static final IOURingSQE ELEMENT_FACTORY = IOURingSQE.create(-1L);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Buffer(ByteBuffer container) {
/*  982 */       super(container, container.remaining() / IOURingSQE.SIZEOF);
/*      */     }
/*      */     
/*      */     public Buffer(long address, int cap) {
/*  986 */       super(address, null, -1, 0, cap, cap);
/*      */     }
/*      */     
/*      */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/*  990 */       super(address, container, mark, pos, lim, cap);
/*      */     }
/*      */ 
/*      */     
/*      */     protected Buffer self() {
/*  995 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 1000 */       return new Buffer(address, container, mark, position, limit, capacity);
/*      */     }
/*      */ 
/*      */     
/*      */     protected IOURingSQE getElementFactory() {
/* 1005 */       return ELEMENT_FACTORY;
/*      */     }
/*      */     
/*      */     @NativeType("__u8")
/*      */     public byte opcode() {
/* 1010 */       return IOURingSQE.nopcode(address());
/*      */     } @NativeType("__u8")
/*      */     public byte flags() {
/* 1013 */       return IOURingSQE.nflags(address());
/*      */     } @NativeType("__u16")
/*      */     public short ioprio() {
/* 1016 */       return IOURingSQE.nioprio(address());
/*      */     } @NativeType("__s32")
/*      */     public int fd() {
/* 1019 */       return IOURingSQE.nfd(address());
/*      */     } @NativeType("__u64")
/*      */     public long off() {
/* 1022 */       return IOURingSQE.noff(address());
/*      */     } @NativeType("__u64")
/*      */     public long addr2() {
/* 1025 */       return IOURingSQE.naddr2(address());
/*      */     } @NativeType("__u32")
/*      */     public int cmd_op() {
/* 1028 */       return IOURingSQE.ncmd_op(address());
/*      */     } @NativeType("__u32")
/*      */     public int __pad1() {
/* 1031 */       return IOURingSQE.n__pad1(address());
/*      */     } @NativeType("__u64")
/*      */     public long addr() {
/* 1034 */       return IOURingSQE.naddr(address());
/*      */     } @NativeType("__u64")
/*      */     public long splice_off_in() {
/* 1037 */       return IOURingSQE.nsplice_off_in(address());
/*      */     } @NativeType("__u32")
/*      */     public int level() {
/* 1040 */       return IOURingSQE.nlevel(address());
/*      */     } @NativeType("__u32")
/*      */     public int optname() {
/* 1043 */       return IOURingSQE.noptname(address());
/*      */     } @NativeType("__u32")
/*      */     public int len() {
/* 1046 */       return IOURingSQE.nlen(address());
/*      */     } @NativeType("__kernel_rwf_t")
/*      */     public int rw_flags() {
/* 1049 */       return IOURingSQE.nrw_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int fsync_flags() {
/* 1052 */       return IOURingSQE.nfsync_flags(address());
/*      */     } @NativeType("__u16")
/*      */     public short poll_events() {
/* 1055 */       return IOURingSQE.npoll_events(address());
/*      */     } @NativeType("__u32")
/*      */     public int poll32_events() {
/* 1058 */       return IOURingSQE.npoll32_events(address());
/*      */     } @NativeType("__u32")
/*      */     public int sync_range_flags() {
/* 1061 */       return IOURingSQE.nsync_range_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int msg_flags() {
/* 1064 */       return IOURingSQE.nmsg_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int timeout_flags() {
/* 1067 */       return IOURingSQE.ntimeout_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int accept_flags() {
/* 1070 */       return IOURingSQE.naccept_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int cancel_flags() {
/* 1073 */       return IOURingSQE.ncancel_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int open_flags() {
/* 1076 */       return IOURingSQE.nopen_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int statx_flags() {
/* 1079 */       return IOURingSQE.nstatx_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int fadvise_advice() {
/* 1082 */       return IOURingSQE.nfadvise_advice(address());
/*      */     } @NativeType("__u32")
/*      */     public int splice_flags() {
/* 1085 */       return IOURingSQE.nsplice_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int rename_flags() {
/* 1088 */       return IOURingSQE.nrename_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int unlink_flags() {
/* 1091 */       return IOURingSQE.nunlink_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int hardlink_flags() {
/* 1094 */       return IOURingSQE.nhardlink_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int xattr_flags() {
/* 1097 */       return IOURingSQE.nxattr_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int msg_ring_flags() {
/* 1100 */       return IOURingSQE.nmsg_ring_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int uring_cmd_flags() {
/* 1103 */       return IOURingSQE.nuring_cmd_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int waitid_flags() {
/* 1106 */       return IOURingSQE.nwaitid_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int futex_flags() {
/* 1109 */       return IOURingSQE.nfutex_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int install_fd_flags() {
/* 1112 */       return IOURingSQE.ninstall_fd_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int nop_flags() {
/* 1115 */       return IOURingSQE.nnop_flags(address());
/*      */     } @NativeType("__u32")
/*      */     public int pipe_flags() {
/* 1118 */       return IOURingSQE.npipe_flags(address());
/*      */     } @NativeType("__u64")
/*      */     public long user_data() {
/* 1121 */       return IOURingSQE.nuser_data(address());
/*      */     } @NativeType("__u16")
/*      */     public short buf_index() {
/* 1124 */       return IOURingSQE.nbuf_index(address());
/*      */     } @NativeType("__u16")
/*      */     public short buf_group() {
/* 1127 */       return IOURingSQE.nbuf_group(address());
/*      */     } @NativeType("__u16")
/*      */     public short personality() {
/* 1130 */       return IOURingSQE.npersonality(address());
/*      */     } @NativeType("__s32")
/*      */     public int splice_fd_in() {
/* 1133 */       return IOURingSQE.nsplice_fd_in(address());
/*      */     } @NativeType("__u32")
/*      */     public int file_index() {
/* 1136 */       return IOURingSQE.nfile_index(address());
/*      */     } @NativeType("__u32")
/*      */     public int zcrx_ifq_idx() {
/* 1139 */       return IOURingSQE.nzcrx_ifq_idx(address());
/*      */     } @NativeType("__u32")
/*      */     public int optlen() {
/* 1142 */       return IOURingSQE.noptlen(address());
/*      */     } @NativeType("__u16")
/*      */     public short addr_len() {
/* 1145 */       return IOURingSQE.naddr_len(address());
/*      */     } @NativeType("__u16[1]")
/*      */     public ShortBuffer __pad3() {
/* 1148 */       return IOURingSQE.n__pad3(address());
/*      */     } @NativeType("__u16")
/*      */     public short __pad3(int index) {
/* 1151 */       return IOURingSQE.n__pad3(address(), index);
/*      */     } @NativeType("__u64")
/*      */     public long addr3() {
/* 1154 */       return IOURingSQE.naddr3(address());
/*      */     } @NativeType("__u64[1]")
/*      */     public LongBuffer __pad2() {
/* 1157 */       return IOURingSQE.n__pad2(address());
/*      */     } @NativeType("__u64")
/*      */     public long __pad2(int index) {
/* 1160 */       return IOURingSQE.n__pad2(address(), index);
/*      */     } @NativeType("__u64")
/*      */     public long attr_ptr() {
/* 1163 */       return IOURingSQE.nattr_ptr(address());
/*      */     } @NativeType("__u64")
/*      */     public long attr_type_mask() {
/* 1166 */       return IOURingSQE.nattr_type_mask(address());
/*      */     } @NativeType("__u64")
/*      */     public long optval() {
/* 1169 */       return IOURingSQE.noptval(address());
/*      */     } @NativeType("__u8[0]")
/*      */     public ByteBuffer cmd() {
/* 1172 */       return IOURingSQE.ncmd(address());
/*      */     } @NativeType("__u8")
/*      */     public byte cmd(int index) {
/* 1175 */       return IOURingSQE.ncmd(address(), index);
/*      */     }
/*      */     public Buffer opcode(@NativeType("__u8") byte value) {
/* 1178 */       IOURingSQE.nopcode(address(), value); return this;
/*      */     } public Buffer flags(@NativeType("__u8") byte value) {
/* 1180 */       IOURingSQE.nflags(address(), value); return this;
/*      */     } public Buffer ioprio(@NativeType("__u16") short value) {
/* 1182 */       IOURingSQE.nioprio(address(), value); return this;
/*      */     } public Buffer fd(@NativeType("__s32") int value) {
/* 1184 */       IOURingSQE.nfd(address(), value); return this;
/*      */     } public Buffer off(@NativeType("__u64") long value) {
/* 1186 */       IOURingSQE.noff(address(), value); return this;
/*      */     } public Buffer addr2(@NativeType("__u64") long value) {
/* 1188 */       IOURingSQE.naddr2(address(), value); return this;
/*      */     } public Buffer cmd_op(@NativeType("__u32") int value) {
/* 1190 */       IOURingSQE.ncmd_op(address(), value); return this;
/*      */     } public Buffer __pad1(@NativeType("__u32") int value) {
/* 1192 */       IOURingSQE.n__pad1(address(), value); return this;
/*      */     } public Buffer addr(@NativeType("__u64") long value) {
/* 1194 */       IOURingSQE.naddr(address(), value); return this;
/*      */     } public Buffer splice_off_in(@NativeType("__u64") long value) {
/* 1196 */       IOURingSQE.nsplice_off_in(address(), value); return this;
/*      */     } public Buffer level(@NativeType("__u32") int value) {
/* 1198 */       IOURingSQE.nlevel(address(), value); return this;
/*      */     } public Buffer optname(@NativeType("__u32") int value) {
/* 1200 */       IOURingSQE.noptname(address(), value); return this;
/*      */     } public Buffer len(@NativeType("__u32") int value) {
/* 1202 */       IOURingSQE.nlen(address(), value); return this;
/*      */     } public Buffer rw_flags(@NativeType("__kernel_rwf_t") int value) {
/* 1204 */       IOURingSQE.nrw_flags(address(), value); return this;
/*      */     } public Buffer fsync_flags(@NativeType("__u32") int value) {
/* 1206 */       IOURingSQE.nfsync_flags(address(), value); return this;
/*      */     } public Buffer poll_events(@NativeType("__u16") short value) {
/* 1208 */       IOURingSQE.npoll_events(address(), value); return this;
/*      */     } public Buffer poll32_events(@NativeType("__u32") int value) {
/* 1210 */       IOURingSQE.npoll32_events(address(), value); return this;
/*      */     } public Buffer sync_range_flags(@NativeType("__u32") int value) {
/* 1212 */       IOURingSQE.nsync_range_flags(address(), value); return this;
/*      */     } public Buffer msg_flags(@NativeType("__u32") int value) {
/* 1214 */       IOURingSQE.nmsg_flags(address(), value); return this;
/*      */     } public Buffer timeout_flags(@NativeType("__u32") int value) {
/* 1216 */       IOURingSQE.ntimeout_flags(address(), value); return this;
/*      */     } public Buffer accept_flags(@NativeType("__u32") int value) {
/* 1218 */       IOURingSQE.naccept_flags(address(), value); return this;
/*      */     } public Buffer cancel_flags(@NativeType("__u32") int value) {
/* 1220 */       IOURingSQE.ncancel_flags(address(), value); return this;
/*      */     } public Buffer open_flags(@NativeType("__u32") int value) {
/* 1222 */       IOURingSQE.nopen_flags(address(), value); return this;
/*      */     } public Buffer statx_flags(@NativeType("__u32") int value) {
/* 1224 */       IOURingSQE.nstatx_flags(address(), value); return this;
/*      */     } public Buffer fadvise_advice(@NativeType("__u32") int value) {
/* 1226 */       IOURingSQE.nfadvise_advice(address(), value); return this;
/*      */     } public Buffer splice_flags(@NativeType("__u32") int value) {
/* 1228 */       IOURingSQE.nsplice_flags(address(), value); return this;
/*      */     } public Buffer rename_flags(@NativeType("__u32") int value) {
/* 1230 */       IOURingSQE.nrename_flags(address(), value); return this;
/*      */     } public Buffer unlink_flags(@NativeType("__u32") int value) {
/* 1232 */       IOURingSQE.nunlink_flags(address(), value); return this;
/*      */     } public Buffer hardlink_flags(@NativeType("__u32") int value) {
/* 1234 */       IOURingSQE.nhardlink_flags(address(), value); return this;
/*      */     } public Buffer xattr_flags(@NativeType("__u32") int value) {
/* 1236 */       IOURingSQE.nxattr_flags(address(), value); return this;
/*      */     } public Buffer msg_ring_flags(@NativeType("__u32") int value) {
/* 1238 */       IOURingSQE.nmsg_ring_flags(address(), value); return this;
/*      */     } public Buffer uring_cmd_flags(@NativeType("__u32") int value) {
/* 1240 */       IOURingSQE.nuring_cmd_flags(address(), value); return this;
/*      */     } public Buffer waitid_flags(@NativeType("__u32") int value) {
/* 1242 */       IOURingSQE.nwaitid_flags(address(), value); return this;
/*      */     } public Buffer futex_flags(@NativeType("__u32") int value) {
/* 1244 */       IOURingSQE.nfutex_flags(address(), value); return this;
/*      */     } public Buffer install_fd_flags(@NativeType("__u32") int value) {
/* 1246 */       IOURingSQE.ninstall_fd_flags(address(), value); return this;
/*      */     } public Buffer nop_flags(@NativeType("__u32") int value) {
/* 1248 */       IOURingSQE.nnop_flags(address(), value); return this;
/*      */     } public Buffer pipe_flags(@NativeType("__u32") int value) {
/* 1250 */       IOURingSQE.npipe_flags(address(), value); return this;
/*      */     } public Buffer user_data(@NativeType("__u64") long value) {
/* 1252 */       IOURingSQE.nuser_data(address(), value); return this;
/*      */     } public Buffer buf_index(@NativeType("__u16") short value) {
/* 1254 */       IOURingSQE.nbuf_index(address(), value); return this;
/*      */     } public Buffer buf_group(@NativeType("__u16") short value) {
/* 1256 */       IOURingSQE.nbuf_group(address(), value); return this;
/*      */     } public Buffer personality(@NativeType("__u16") short value) {
/* 1258 */       IOURingSQE.npersonality(address(), value); return this;
/*      */     } public Buffer splice_fd_in(@NativeType("__s32") int value) {
/* 1260 */       IOURingSQE.nsplice_fd_in(address(), value); return this;
/*      */     } public Buffer file_index(@NativeType("__u32") int value) {
/* 1262 */       IOURingSQE.nfile_index(address(), value); return this;
/*      */     } public Buffer zcrx_ifq_idx(@NativeType("__u32") int value) {
/* 1264 */       IOURingSQE.nzcrx_ifq_idx(address(), value); return this;
/*      */     } public Buffer optlen(@NativeType("__u32") int value) {
/* 1266 */       IOURingSQE.noptlen(address(), value); return this;
/*      */     } public Buffer addr_len(@NativeType("__u16") short value) {
/* 1268 */       IOURingSQE.naddr_len(address(), value); return this;
/*      */     } public Buffer __pad3(@NativeType("__u16[1]") ShortBuffer value) {
/* 1270 */       IOURingSQE.n__pad3(address(), value); return this;
/*      */     } public Buffer __pad3(int index, @NativeType("__u16") short value) {
/* 1272 */       IOURingSQE.n__pad3(address(), index, value); return this;
/*      */     } public Buffer addr3(@NativeType("__u64") long value) {
/* 1274 */       IOURingSQE.naddr3(address(), value); return this;
/*      */     } public Buffer __pad2(@NativeType("__u64[1]") LongBuffer value) {
/* 1276 */       IOURingSQE.n__pad2(address(), value); return this;
/*      */     } public Buffer __pad2(int index, @NativeType("__u64") long value) {
/* 1278 */       IOURingSQE.n__pad2(address(), index, value); return this;
/*      */     } public Buffer attr_ptr(@NativeType("__u64") long value) {
/* 1280 */       IOURingSQE.nattr_ptr(address(), value); return this;
/*      */     } public Buffer attr_type_mask(@NativeType("__u64") long value) {
/* 1282 */       IOURingSQE.nattr_type_mask(address(), value); return this;
/*      */     } public Buffer optval(@NativeType("__u64") long value) {
/* 1284 */       IOURingSQE.noptval(address(), value); return this;
/*      */     } public Buffer cmd(@NativeType("__u8[0]") ByteBuffer value) {
/* 1286 */       IOURingSQE.ncmd(address(), value); return this;
/*      */     } public Buffer cmd(int index, @NativeType("__u8") byte value) {
/* 1288 */       IOURingSQE.ncmd(address(), index, value); return this;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingSQE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */