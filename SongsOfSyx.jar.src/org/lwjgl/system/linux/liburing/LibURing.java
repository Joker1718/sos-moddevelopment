/*      */ package org.lwjgl.system.linux.liburing;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ import org.lwjgl.system.Pointer;
/*      */ import org.lwjgl.system.linux.CMsghdr;
/*      */ import org.lwjgl.system.linux.EpollEvent;
/*      */ import org.lwjgl.system.linux.IOVec;
/*      */ import org.lwjgl.system.linux.KernelTimespec;
/*      */ import org.lwjgl.system.linux.Msghdr;
/*      */ import org.lwjgl.system.linux.OpenHow;
/*      */ import org.lwjgl.system.linux.Sockaddr;
/*      */ import org.lwjgl.system.linux.Statx;
/*      */ 
/*      */ public class LibURing {
/*      */   static {
/*   24 */     Library.initialize();
/*      */   }
/*      */   public static final long LIBURING_UDATA_TIMEOUT = -1L;
/*      */   
/*      */   protected LibURing() {
/*   29 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("struct io_uring_probe *")
/*      */   public static IOURingProbe io_uring_get_probe_ring(@NativeType("struct io_uring *") IOURing ring) {
/*   40 */     long __result = nio_uring_get_probe_ring(ring.address());
/*   41 */     return IOURingProbe.createSafe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("struct io_uring_probe *")
/*      */   public static IOURingProbe io_uring_get_probe() {
/*   52 */     long __result = nio_uring_get_probe();
/*   53 */     return IOURingProbe.createSafe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_free_probe(@NativeType("struct io_uring_probe *") IOURingProbe probe) {
/*   63 */     nio_uring_free_probe(probe.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_opcode_supported(@NativeType("struct io_uring_probe const *") IOURingProbe p, int op) {
/*   73 */     return nio_uring_opcode_supported(p.address(), op);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_queue_init_mem(@NativeType("unsigned") int entries, @NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_params *") IOURingParams p, @NativeType("void *") ByteBuffer buf) {
/*   83 */     return nio_uring_queue_init_mem(entries, ring.address(), p.address(), MemoryUtil.memAddress(buf), buf.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_queue_init_params(@NativeType("unsigned") int entries, @NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_params *") IOURingParams p) {
/*   93 */     return nio_uring_queue_init_params(entries, ring.address(), p.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_queue_init(@NativeType("unsigned") int entries, @NativeType("struct io_uring *") IOURing ring, @NativeType("unsigned") int flags) {
/*  103 */     return nio_uring_queue_init(entries, ring.address(), flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_queue_mmap(int fd, @NativeType("struct io_uring_params *") IOURingParams p, @NativeType("struct io_uring *") IOURing ring) {
/*  113 */     return nio_uring_queue_mmap(fd, p.address(), ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_ring_dontfork(@NativeType("struct io_uring *") IOURing ring) {
/*  123 */     return nio_uring_ring_dontfork(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_queue_exit(@NativeType("struct io_uring *") IOURing ring) {
/*  133 */     nio_uring_queue_exit(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned")
/*      */   public static int io_uring_peek_batch_cqe(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_cqe **") PointerBuffer cqes) {
/*  144 */     return nio_uring_peek_batch_cqe(ring.address(), MemoryUtil.memAddress((CustomBuffer)cqes), cqes.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_wait_cqes(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_cqe **") PointerBuffer cqe_ptr, @NativeType("struct __kernel_timespec *") KernelTimespec ts, @NativeType("sigset_t *") long sigmask) {
/*  154 */     return nio_uring_wait_cqes(ring.address(), MemoryUtil.memAddress((CustomBuffer)cqe_ptr), cqe_ptr.remaining(), MemoryUtil.memAddressSafe((Pointer)ts), sigmask);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_wait_cqes_min_timeout(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_cqe **") PointerBuffer cqe_ptr, @NativeType("struct __kernel_timespec *") KernelTimespec ts, @NativeType("unsigned int") int min_ts_usec, @NativeType("sigset_t *") long sigmask) {
/*  164 */     return nio_uring_wait_cqes_min_timeout(ring.address(), MemoryUtil.memAddress((CustomBuffer)cqe_ptr), cqe_ptr.remaining(), MemoryUtil.memAddressSafe((Pointer)ts), min_ts_usec, sigmask);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_wait_cqe_timeout(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_cqe **") PointerBuffer cqe_ptr, @NativeType("struct __kernel_timespec *") KernelTimespec ts) {
/*  174 */     if (Checks.CHECKS) {
/*  175 */       Checks.check((CustomBuffer)cqe_ptr, 1);
/*      */     }
/*  177 */     return nio_uring_wait_cqe_timeout(ring.address(), MemoryUtil.memAddress((CustomBuffer)cqe_ptr), MemoryUtil.memAddressSafe((Pointer)ts));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_submit(@NativeType("struct io_uring *") IOURing ring) {
/*  187 */     return nio_uring_submit(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_submit_and_wait(@NativeType("struct io_uring *") IOURing ring, @NativeType("unsigned") int wait_nr) {
/*  197 */     return nio_uring_submit_and_wait(ring.address(), wait_nr);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_submit_and_wait_timeout(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_cqe **") PointerBuffer cqe_ptr, @NativeType("struct __kernel_timespec *") KernelTimespec ts, @NativeType("sigset_t *") long sigmask) {
/*  207 */     return nio_uring_submit_and_wait_timeout(ring.address(), MemoryUtil.memAddress((CustomBuffer)cqe_ptr), cqe_ptr.remaining(), MemoryUtil.memAddressSafe((Pointer)ts), sigmask);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_submit_and_wait_min_timeout(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_cqe **") PointerBuffer cqe_ptr, @NativeType("struct __kernel_timespec *") KernelTimespec ts, @NativeType("unsigned") int min_wait, @NativeType("sigset_t *") long sigmask) {
/*  217 */     return nio_uring_submit_and_wait_min_timeout(ring.address(), MemoryUtil.memAddress((CustomBuffer)cqe_ptr), cqe_ptr.remaining(), MemoryUtil.memAddressSafe((Pointer)ts), min_wait, sigmask);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_submit_and_wait_reg(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_cqe **") PointerBuffer cqe_ptr, int reg_index) {
/*  227 */     return nio_uring_submit_and_wait_reg(ring.address(), MemoryUtil.memAddress((CustomBuffer)cqe_ptr), cqe_ptr.remaining(), reg_index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_wait_reg(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_reg_wait *") IOURingRegWait reg, int nr) {
/*  237 */     return nio_uring_register_wait_reg(ring.address(), reg.address(), nr);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_resize_rings(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_params *") IOURingParams p) {
/*  247 */     return nio_uring_resize_rings(ring.address(), p.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_clone_buffers_offset(@NativeType("struct io_uring *") IOURing dst, @NativeType("struct io_uring *") IOURing src, @NativeType("unsigned") int dst_off, @NativeType("unsigned") int src_off, @NativeType("unsigned") int nr, @NativeType("unsigned") int flags) {
/*  257 */     return nio_uring_clone_buffers_offset(dst.address(), src.address(), dst_off, src_off, nr, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_clone_buffers(@NativeType("struct io_uring *") IOURing dst, @NativeType("struct io_uring *") IOURing src) {
/*  267 */     return nio_uring_clone_buffers(dst.address(), src.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_buffers(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct iovec const *") IOVec.Buffer iovecs) {
/*  277 */     return nio_uring_register_buffers(ring.address(), iovecs.address(), iovecs.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_buffers_tags(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct iovec const *") IOVec.Buffer iovecs, @NativeType("__u64 const *") LongBuffer tags) {
/*  287 */     if (Checks.CHECKS) {
/*  288 */       Checks.check(tags, iovecs.remaining());
/*      */     }
/*  290 */     return nio_uring_register_buffers_tags(ring.address(), iovecs.address(), MemoryUtil.memAddress(tags), iovecs.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_buffers_sparse(@NativeType("struct io_uring *") IOURing ring, @NativeType("unsigned") int nr_iovecs) {
/*  300 */     return nio_uring_register_buffers_sparse(ring.address(), nr_iovecs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_buffers_update_tag(@NativeType("struct io_uring *") IOURing ring, @NativeType("unsigned") int off, @NativeType("struct iovec const *") IOVec.Buffer iovecs, @NativeType("__u64 const *") LongBuffer tags) {
/*  310 */     if (Checks.CHECKS) {
/*  311 */       Checks.check(tags, iovecs.remaining());
/*      */     }
/*  313 */     return nio_uring_register_buffers_update_tag(ring.address(), off, iovecs.address(), MemoryUtil.memAddress(tags), iovecs.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_unregister_buffers(@NativeType("struct io_uring *") IOURing ring) {
/*  323 */     return nio_uring_unregister_buffers(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_files(@NativeType("struct io_uring *") IOURing ring, @NativeType("int const *") IntBuffer files) {
/*  333 */     return nio_uring_register_files(ring.address(), MemoryUtil.memAddress(files), files.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_files_tags(@NativeType("struct io_uring *") IOURing ring, @NativeType("int const *") IntBuffer files, @NativeType("__u64 const *") LongBuffer tags) {
/*  343 */     if (Checks.CHECKS) {
/*  344 */       Checks.check(tags, files.remaining());
/*      */     }
/*  346 */     return nio_uring_register_files_tags(ring.address(), MemoryUtil.memAddress(files), MemoryUtil.memAddress(tags), files.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_files_sparse(@NativeType("struct io_uring *") IOURing ring, @NativeType("unsigned") int nr_files) {
/*  356 */     return nio_uring_register_files_sparse(ring.address(), nr_files);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_files_update_tag(@NativeType("struct io_uring *") IOURing ring, @NativeType("unsigned") int off, @NativeType("int const *") IntBuffer files, @NativeType("__u64 const *") LongBuffer tags) {
/*  366 */     if (Checks.CHECKS) {
/*  367 */       Checks.check(tags, files.remaining());
/*      */     }
/*  369 */     return nio_uring_register_files_update_tag(ring.address(), off, MemoryUtil.memAddress(files), MemoryUtil.memAddress(tags), files.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_unregister_files(@NativeType("struct io_uring *") IOURing ring) {
/*  379 */     return nio_uring_unregister_files(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_files_update(@NativeType("struct io_uring *") IOURing ring, @NativeType("unsigned") int off, @NativeType("int const *") IntBuffer files) {
/*  389 */     return nio_uring_register_files_update(ring.address(), off, MemoryUtil.memAddress(files), files.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_eventfd(@NativeType("struct io_uring *") IOURing ring, int fd) {
/*  399 */     return nio_uring_register_eventfd(ring.address(), fd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_eventfd_async(@NativeType("struct io_uring *") IOURing ring, int fd) {
/*  409 */     return nio_uring_register_eventfd_async(ring.address(), fd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_unregister_eventfd(@NativeType("struct io_uring *") IOURing ring) {
/*  419 */     return nio_uring_unregister_eventfd(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_probe(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_probe *") IOURingProbe p, @NativeType("unsigned") int nr) {
/*  429 */     return nio_uring_register_probe(ring.address(), p.address(), nr);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_personality(@NativeType("struct io_uring *") IOURing ring) {
/*  439 */     return nio_uring_register_personality(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_unregister_personality(@NativeType("struct io_uring *") IOURing ring, int id) {
/*  449 */     return nio_uring_unregister_personality(ring.address(), id);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_restrictions(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_restriction *") IOURingRestriction.Buffer res) {
/*  459 */     return nio_uring_register_restrictions(ring.address(), res.address(), res.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_enable_rings(@NativeType("struct io_uring *") IOURing ring) {
/*  469 */     return nio_uring_enable_rings(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int __io_uring_sqring_wait(@NativeType("struct io_uring *") IOURing ring) {
/*  479 */     return n__io_uring_sqring_wait(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_iowq_aff(@NativeType("struct io_uring *") IOURing ring, @NativeType("size_t") long cpusz, @NativeType("cpu_set_t const *") long mask) {
/*  489 */     if (Checks.CHECKS) {
/*  490 */       Checks.check(mask);
/*      */     }
/*  492 */     return nio_uring_register_iowq_aff(ring.address(), cpusz, mask);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_unregister_iowq_aff(@NativeType("struct io_uring *") IOURing ring) {
/*  502 */     return nio_uring_unregister_iowq_aff(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_iowq_max_workers(@NativeType("struct io_uring *") IOURing ring, @NativeType("unsigned int *") IntBuffer values) {
/*  512 */     if (Checks.CHECKS) {
/*  513 */       Checks.check(values, 2);
/*      */     }
/*  515 */     return nio_uring_register_iowq_max_workers(ring.address(), MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_ring_fd(@NativeType("struct io_uring *") IOURing ring) {
/*  525 */     return nio_uring_register_ring_fd(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_unregister_ring_fd(@NativeType("struct io_uring *") IOURing ring) {
/*  535 */     return nio_uring_unregister_ring_fd(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_close_ring_fd(@NativeType("struct io_uring *") IOURing ring) {
/*  545 */     return nio_uring_close_ring_fd(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_buf_ring(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_buf_reg *") IOURingBufReg reg, @NativeType("unsigned int") int flags) {
/*  555 */     return nio_uring_register_buf_ring(ring.address(), reg.address(), flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_unregister_buf_ring(@NativeType("struct io_uring *") IOURing ring, int bgid) {
/*  565 */     return nio_uring_unregister_buf_ring(ring.address(), bgid);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_buf_ring_head(@NativeType("struct io_uring *") IOURing ring, int buf_group, @NativeType("unsigned short *") ShortBuffer head) {
/*  575 */     if (Checks.CHECKS) {
/*  576 */       Checks.check(head, 1);
/*      */     }
/*  578 */     return nio_uring_buf_ring_head(ring.address(), buf_group, MemoryUtil.memAddress(head));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_sync_cancel(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_sync_cancel_reg *") IOURingSyncCancelReg reg) {
/*  588 */     return nio_uring_register_sync_cancel(ring.address(), reg.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_file_alloc_range(@NativeType("struct io_uring *") IOURing ring, @NativeType("unsigned") int off, @NativeType("unsigned") int len) {
/*  598 */     return nio_uring_register_file_alloc_range(ring.address(), off, len);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_napi(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_napi *") IOURingNAPI napi) {
/*  608 */     return nio_uring_register_napi(ring.address(), napi.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_unregister_napi(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_napi *") IOURingNAPI napi) {
/*  618 */     return nio_uring_unregister_napi(ring.address(), napi.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_ifq(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_zcrx_ifq_reg *") IOURingZCRXIfqReg reg) {
/*  628 */     return nio_uring_register_ifq(ring.address(), reg.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_register_clock(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_clock_register *") IOURingClockRegister arg) {
/*  638 */     return nio_uring_register_clock(ring.address(), arg.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_get_events(@NativeType("struct io_uring *") IOURing ring) {
/*  648 */     return nio_uring_get_events(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_submit_and_get_events(@NativeType("struct io_uring *") IOURing ring) {
/*  658 */     return nio_uring_submit_and_get_events(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_enter(@NativeType("unsigned int") int fd, @NativeType("unsigned int") int to_submit, @NativeType("unsigned int") int min_complete, @NativeType("unsigned int") int flags, @NativeType("sigset_t *") long sig) {
/*  668 */     if (Checks.CHECKS) {
/*  669 */       Checks.check(sig);
/*      */     }
/*  671 */     return nio_uring_enter(fd, to_submit, min_complete, flags, sig);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_enter2(@NativeType("unsigned int") int fd, @NativeType("unsigned int") int to_submit, @NativeType("unsigned int") int min_complete, @NativeType("unsigned int") int flags, @NativeType("void *") ByteBuffer arg) {
/*  681 */     return nio_uring_enter2(fd, to_submit, min_complete, flags, MemoryUtil.memAddress(arg), arg.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_setup(@NativeType("unsigned int") int entries, @NativeType("struct io_uring_params *") IOURingParams p) {
/*  691 */     return nio_uring_setup(entries, p.address());
/*      */   }
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
/*      */   public static int io_uring_register_region(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_mem_region_reg *") IOURingMemRegionReg reg) {
/*  706 */     return nio_uring_register_region(ring.address(), reg.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("struct io_uring_buf_ring *")
/*      */   public static IOURingBufRing io_uring_setup_buf_ring(@NativeType("struct io_uring *") IOURing ring, @NativeType("unsigned int") int nentries, int bgid, @NativeType("unsigned int") int flags, @NativeType("int *") IntBuffer err) {
/*  717 */     if (Checks.CHECKS) {
/*  718 */       Checks.check(err, 1);
/*      */     }
/*  720 */     long __result = nio_uring_setup_buf_ring(ring.address(), nentries, bgid, flags, MemoryUtil.memAddress(err));
/*  721 */     return IOURingBufRing.createSafe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_free_buf_ring(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_buf_ring *") IOURingBufRing br, @NativeType("unsigned int") int nentries, int bgid) {
/*  731 */     return nio_uring_free_buf_ring(ring.address(), br.address(), nentries, bgid);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_set_iowait(@NativeType("struct io_uring *") IOURing ring, @NativeType("bool") boolean enable_iowait) {
/*  741 */     return nio_uring_set_iowait(ring.address(), enable_iowait);
/*      */   }
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
/*      */   @NativeType("unsigned")
/*      */   public static int io_uring_cqe_shift(@NativeType("struct io_uring const *") IOURing ring) {
/*  758 */     if (Checks.CHECKS) {
/*  759 */       IOURing.validate(ring.address());
/*      */     }
/*  761 */     return nio_uring_cqe_shift(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned")
/*      */   public static int io_uring_cqe_nr(@NativeType("struct io_uring_cqe const *") IOURingCQE cqe) {
/*  772 */     return nio_uring_cqe_nr(cqe.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_cq_advance(@NativeType("struct io_uring *") IOURing ring, @NativeType("unsigned") int nr) {
/*  782 */     nio_uring_cq_advance(ring.address(), nr);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_cqe_seen(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_cqe *") IOURingCQE cqe) {
/*  792 */     nio_uring_cqe_seen(ring.address(), cqe.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_sqe_set_data(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("void *") long data) {
/*  802 */     if (Checks.CHECKS) {
/*  803 */       Checks.check(data);
/*      */     }
/*  805 */     nio_uring_sqe_set_data(sqe.address(), data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static long io_uring_cqe_get_data(@NativeType("struct io_uring_cqe const *") IOURingCQE cqe) {
/*  816 */     return nio_uring_cqe_get_data(cqe.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_sqe_set_data64(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("__u64") long data) {
/*  826 */     nio_uring_sqe_set_data64(sqe.address(), data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("__u64")
/*      */   public static long io_uring_cqe_get_data64(@NativeType("struct io_uring_cqe const *") IOURingCQE cqe) {
/*  837 */     return nio_uring_cqe_get_data64(cqe.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_sqe_set_flags(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("unsigned int") int flags) {
/*  847 */     nio_uring_sqe_set_flags(sqe.address(), flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_sqe_set_buf_group(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int bgid) {
/*  857 */     nio_uring_sqe_set_buf_group(sqe.address(), bgid);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_initialize_sqe(@NativeType("struct io_uring_sqe *") IOURingSQE sqe) {
/*  867 */     nio_uring_initialize_sqe(sqe.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_splice(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd_in, @NativeType("int64_t") long off_in, int fd_out, @NativeType("int64_t") long off_out, @NativeType("unsigned int") int nbytes, @NativeType("unsigned int") int splice_flags) {
/*  877 */     nio_uring_prep_splice(sqe.address(), fd_in, off_in, fd_out, off_out, nbytes, splice_flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_tee(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd_in, int fd_out, @NativeType("unsigned int") int nbytes, @NativeType("unsigned int") int splice_flags) {
/*  887 */     nio_uring_prep_tee(sqe.address(), fd_in, fd_out, nbytes, splice_flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_readv(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct iovec const *") IOVec.Buffer iovecs, int offset) {
/*  897 */     nio_uring_prep_readv(sqe.address(), fd, iovecs.address(), iovecs.remaining(), offset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_readv2(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct iovec const *") IOVec.Buffer iovecs, int offset, int flags) {
/*  907 */     nio_uring_prep_readv2(sqe.address(), fd, iovecs.address(), iovecs.remaining(), offset, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_read_fixed(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("void *") ByteBuffer buf, @NativeType("__u64") long offset, int buf_index) {
/*  917 */     nio_uring_prep_read_fixed(sqe.address(), fd, MemoryUtil.memAddress(buf), buf.remaining(), offset, buf_index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_readv_fixed(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct iovec const *") IOVec.Buffer iovecs, @NativeType("__u64") long offset, int flags, int buf_index) {
/*  927 */     nio_uring_prep_readv_fixed(sqe.address(), fd, iovecs.address(), iovecs.remaining(), offset, flags, buf_index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_writev(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct iovec const *") IOVec.Buffer iovecs, @NativeType("__u64") long offset) {
/*  937 */     nio_uring_prep_writev(sqe.address(), fd, iovecs.address(), iovecs.remaining(), offset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_writev2(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct iovec const *") IOVec.Buffer iovecs, @NativeType("__u64") long offset, int flags) {
/*  947 */     nio_uring_prep_writev2(sqe.address(), fd, iovecs.address(), iovecs.remaining(), offset, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_write_fixed(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("void const *") ByteBuffer buf, @NativeType("__u64") long offset, int buf_index) {
/*  957 */     nio_uring_prep_write_fixed(sqe.address(), fd, MemoryUtil.memAddress(buf), buf.remaining(), offset, buf_index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_writev_fixed(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct iovec const *") IOVec.Buffer iovecs, @NativeType("__u64") long offset, int flags, int buf_index) {
/*  967 */     nio_uring_prep_writev_fixed(sqe.address(), fd, iovecs.address(), iovecs.remaining(), offset, flags, buf_index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_recvmsg(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct msghdr *") Msghdr msg, @NativeType("unsigned") int flags) {
/*  977 */     nio_uring_prep_recvmsg(sqe.address(), fd, msg.address(), flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_recvmsg_multishot(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct msghdr *") Msghdr msg, @NativeType("unsigned") int flags) {
/*  987 */     nio_uring_prep_recvmsg_multishot(sqe.address(), fd, msg.address(), flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_sendmsg(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct msghdr const *") Msghdr msg, @NativeType("unsigned") int flags) {
/*  997 */     if (Checks.CHECKS) {
/*  998 */       Msghdr.validate(msg.address());
/*      */     }
/* 1000 */     nio_uring_prep_sendmsg(sqe.address(), fd, msg.address(), flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_poll_add(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("unsigned") int poll_mask) {
/* 1010 */     nio_uring_prep_poll_add(sqe.address(), fd, poll_mask);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_poll_multishot(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("unsigned") int poll_mask) {
/* 1020 */     nio_uring_prep_poll_multishot(sqe.address(), fd, poll_mask);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_poll_remove(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("__u64") long user_data) {
/* 1030 */     nio_uring_prep_poll_remove(sqe.address(), user_data);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_poll_update(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("__u64") long old_user_data, @NativeType("__u64") long new_user_data, @NativeType("unsigned") int poll_mask, @NativeType("unsigned") int flags) {
/* 1040 */     nio_uring_prep_poll_update(sqe.address(), old_user_data, new_user_data, poll_mask, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_fsync(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("unsigned") int fsync_flags) {
/* 1050 */     nio_uring_prep_fsync(sqe.address(), fd, fsync_flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_nop(@NativeType("struct io_uring_sqe *") IOURingSQE sqe) {
/* 1060 */     nio_uring_prep_nop(sqe.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_nop128(@NativeType("struct io_uring_sqe *") IOURingSQE sqe) {
/* 1070 */     nio_uring_prep_nop128(sqe.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_timeout(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("struct __kernel_timespec const *") KernelTimespec ts, @NativeType("unsigned") int count, @NativeType("unsigned") int flags) {
/* 1080 */     nio_uring_prep_timeout(sqe.address(), ts.address(), count, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_timeout_remove(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("__u64") long user_data, @NativeType("unsigned") int flags) {
/* 1090 */     nio_uring_prep_timeout_remove(sqe.address(), user_data, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_timeout_update(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("struct __kernel_timespec const *") KernelTimespec ts, @NativeType("__u64") long user_data, @NativeType("unsigned") int flags) {
/* 1100 */     nio_uring_prep_timeout_update(sqe.address(), ts.address(), user_data, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_accept(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct sockaddr *") Sockaddr addr, @NativeType("socklen_t *") IntBuffer addrlen, int flags) {
/* 1110 */     if (Checks.CHECKS) {
/* 1111 */       Checks.check(addrlen, 1);
/*      */     }
/* 1113 */     nio_uring_prep_accept(sqe.address(), fd, addr.address(), MemoryUtil.memAddress(addrlen), flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_accept_direct(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct sockaddr *") Sockaddr addr, @NativeType("socklen_t *") IntBuffer addrlen, int flags, @NativeType("unsigned int") int file_index) {
/* 1123 */     if (Checks.CHECKS) {
/* 1124 */       Checks.check(addrlen, 1);
/*      */     }
/* 1126 */     nio_uring_prep_accept_direct(sqe.address(), fd, addr.address(), MemoryUtil.memAddress(addrlen), flags, file_index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_multishot_accept(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct sockaddr *") Sockaddr addr, @NativeType("socklen_t *") IntBuffer addrlen, int flags) {
/* 1136 */     if (Checks.CHECKS) {
/* 1137 */       Checks.check(addrlen, 1);
/*      */     }
/* 1139 */     nio_uring_prep_multishot_accept(sqe.address(), fd, addr.address(), MemoryUtil.memAddress(addrlen), flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_multishot_accept_direct(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct sockaddr *") Sockaddr addr, @NativeType("socklen_t *") IntBuffer addrlen, int flags) {
/* 1149 */     if (Checks.CHECKS) {
/* 1150 */       Checks.check(addrlen, 1);
/*      */     }
/* 1152 */     nio_uring_prep_multishot_accept_direct(sqe.address(), fd, addr.address(), MemoryUtil.memAddress(addrlen), flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_cancel64(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("__u64") long user_data, int flags) {
/* 1162 */     nio_uring_prep_cancel64(sqe.address(), user_data, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_cancel(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("void *") long user_data, int flags) {
/* 1172 */     nio_uring_prep_cancel(sqe.address(), user_data, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_cancel_fd(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("unsigned int") int flags) {
/* 1182 */     nio_uring_prep_cancel_fd(sqe.address(), fd, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_link_timeout(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("struct __kernel_timespec const *") KernelTimespec ts, @NativeType("unsigned") int flags) {
/* 1192 */     nio_uring_prep_link_timeout(sqe.address(), ts.address(), flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_connect(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct sockaddr const *") Sockaddr addr, @NativeType("socklen_t") int addrlen) {
/* 1202 */     nio_uring_prep_connect(sqe.address(), fd, addr.address(), addrlen);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_bind(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct sockaddr const *") Sockaddr addr, @NativeType("socklen_t") int addrlen) {
/* 1212 */     nio_uring_prep_bind(sqe.address(), fd, addr.address(), addrlen);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_listen(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, int backlog) {
/* 1222 */     nio_uring_prep_listen(sqe.address(), fd, backlog);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_epoll_wait(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct epoll_event *") EpollEvent.Buffer events, @NativeType("unsigned") int flags) {
/* 1232 */     nio_uring_prep_epoll_wait(sqe.address(), fd, events.address(), events.remaining(), flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_files_update(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("int const *") IntBuffer fds, int offset) {
/* 1242 */     nio_uring_prep_files_update(sqe.address(), MemoryUtil.memAddress(fds), fds.remaining(), offset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_fallocate(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, int mode, @NativeType("__u64") long offset, @NativeType("__u64") long len) {
/* 1252 */     nio_uring_prep_fallocate(sqe.address(), fd, mode, offset, len);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_openat(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int dfd, @NativeType("char const *") ByteBuffer path, int flags, int mode) {
/* 1262 */     if (Checks.CHECKS) {
/* 1263 */       Checks.checkNT1(path);
/*      */     }
/* 1265 */     nio_uring_prep_openat(sqe.address(), dfd, MemoryUtil.memAddress(path), flags, mode);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_openat(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int dfd, @NativeType("char const *") CharSequence path, int flags, int mode) {
/* 1270 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1272 */       stack.nUTF8(path, true);
/* 1273 */       long pathEncoded = stack.getPointerAddress();
/* 1274 */       nio_uring_prep_openat(sqe.address(), dfd, pathEncoded, flags, mode);
/*      */     } finally {
/* 1276 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_openat_direct(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int dfd, @NativeType("char const *") ByteBuffer path, int flags, int mode, @NativeType("unsigned int") int file_index) {
/* 1287 */     if (Checks.CHECKS) {
/* 1288 */       Checks.checkNT1(path);
/*      */     }
/* 1290 */     nio_uring_prep_openat_direct(sqe.address(), dfd, MemoryUtil.memAddress(path), flags, mode, file_index);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_openat_direct(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int dfd, @NativeType("char const *") CharSequence path, int flags, int mode, @NativeType("unsigned int") int file_index) {
/* 1295 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1297 */       stack.nUTF8(path, true);
/* 1298 */       long pathEncoded = stack.getPointerAddress();
/* 1299 */       nio_uring_prep_openat_direct(sqe.address(), dfd, pathEncoded, flags, mode, file_index);
/*      */     } finally {
/* 1301 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_open(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") ByteBuffer path, int flags, @NativeType("mode_t") int mode) {
/* 1312 */     if (Checks.CHECKS) {
/* 1313 */       Checks.checkNT1(path);
/*      */     }
/* 1315 */     nio_uring_prep_open(sqe.address(), MemoryUtil.memAddress(path), flags, mode);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_open(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") CharSequence path, int flags, @NativeType("mode_t") int mode) {
/* 1320 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1322 */       stack.nUTF8(path, true);
/* 1323 */       long pathEncoded = stack.getPointerAddress();
/* 1324 */       nio_uring_prep_open(sqe.address(), pathEncoded, flags, mode);
/*      */     } finally {
/* 1326 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_open_direct(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") ByteBuffer path, int flags, @NativeType("mode_t") int mode, @NativeType("unsigned") int file_index) {
/* 1337 */     if (Checks.CHECKS) {
/* 1338 */       Checks.checkNT1(path);
/*      */     }
/* 1340 */     nio_uring_prep_open_direct(sqe.address(), MemoryUtil.memAddress(path), flags, mode, file_index);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_open_direct(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") CharSequence path, int flags, @NativeType("mode_t") int mode, @NativeType("unsigned") int file_index) {
/* 1345 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1347 */       stack.nUTF8(path, true);
/* 1348 */       long pathEncoded = stack.getPointerAddress();
/* 1349 */       nio_uring_prep_open_direct(sqe.address(), pathEncoded, flags, mode, file_index);
/*      */     } finally {
/* 1351 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_close(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd) {
/* 1362 */     nio_uring_prep_close(sqe.address(), fd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_close_direct(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("unsigned int") int file_index) {
/* 1372 */     nio_uring_prep_close_direct(sqe.address(), file_index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_read(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("void *") ByteBuffer buf, @NativeType("__u64") long offset) {
/* 1382 */     nio_uring_prep_read(sqe.address(), fd, MemoryUtil.memAddress(buf), buf.remaining(), offset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_read_multishot(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("unsigned int") int nbytes, @NativeType("__u64") long offset, int buf_group) {
/* 1392 */     nio_uring_prep_read_multishot(sqe.address(), fd, nbytes, offset, buf_group);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_write(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("void const *") ByteBuffer buf, @NativeType("__u64") long offset) {
/* 1402 */     nio_uring_prep_write(sqe.address(), fd, MemoryUtil.memAddress(buf), buf.remaining(), offset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_statx(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int dfd, @NativeType("char const *") ByteBuffer path, int flags, @NativeType("unsigned") int mask, @NativeType("struct statx *") Statx statxbuf) {
/* 1412 */     if (Checks.CHECKS) {
/* 1413 */       Checks.checkNT1(path);
/*      */     }
/* 1415 */     nio_uring_prep_statx(sqe.address(), dfd, MemoryUtil.memAddress(path), flags, mask, statxbuf.address());
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_statx(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int dfd, @NativeType("char const *") CharSequence path, int flags, @NativeType("unsigned") int mask, @NativeType("struct statx *") Statx statxbuf) {
/* 1420 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1422 */       stack.nUTF8(path, true);
/* 1423 */       long pathEncoded = stack.getPointerAddress();
/* 1424 */       nio_uring_prep_statx(sqe.address(), dfd, pathEncoded, flags, mask, statxbuf.address());
/*      */     } finally {
/* 1426 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_fadvise(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("__u64") long offset, @NativeType("__u32") int len, int advice) {
/* 1437 */     nio_uring_prep_fadvise(sqe.address(), fd, offset, len, advice);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_madvise(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("void *") ByteBuffer addr, int advice) {
/* 1447 */     nio_uring_prep_madvise(sqe.address(), MemoryUtil.memAddress(addr), addr.remaining(), advice);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_fadvise64(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("__u64") long offset, @NativeType("off_t") long len, int advice) {
/* 1457 */     nio_uring_prep_fadvise64(sqe.address(), fd, offset, len, advice);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_madvise64(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("void *") ByteBuffer addr, int advice) {
/* 1467 */     nio_uring_prep_madvise64(sqe.address(), MemoryUtil.memAddress(addr), addr.remaining(), advice);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_send(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int sockfd, @NativeType("void const *") ByteBuffer buf, int flags) {
/* 1477 */     nio_uring_prep_send(sqe.address(), sockfd, MemoryUtil.memAddress(buf), buf.remaining(), flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_send_bundle(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int sockfd, @NativeType("size_t") long len, int flags) {
/* 1487 */     nio_uring_prep_send_bundle(sqe.address(), sockfd, len, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_send_set_addr(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("struct sockaddr const *") Sockaddr dest_addr, @NativeType("__u16") short addr_len) {
/* 1497 */     nio_uring_prep_send_set_addr(sqe.address(), dest_addr.address(), addr_len);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_sendto(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int sockfd, @NativeType("void const *") ByteBuffer buf, int flags, @NativeType("struct sockaddr const *") Sockaddr addr, @NativeType("socklen_t") int addrlen) {
/* 1507 */     nio_uring_prep_sendto(sqe.address(), sockfd, MemoryUtil.memAddress(buf), buf.remaining(), flags, addr.address(), addrlen);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_send_zc(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int sockfd, @NativeType("void const *") ByteBuffer buf, int flags, @NativeType("unsigned") int zc_flags) {
/* 1517 */     nio_uring_prep_send_zc(sqe.address(), sockfd, MemoryUtil.memAddress(buf), buf.remaining(), flags, zc_flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_send_zc_fixed(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int sockfd, @NativeType("void const *") ByteBuffer buf, int flags, @NativeType("unsigned") int zc_flags, @NativeType("unsigned") int buf_index) {
/* 1527 */     nio_uring_prep_send_zc_fixed(sqe.address(), sockfd, MemoryUtil.memAddress(buf), buf.remaining(), flags, zc_flags, buf_index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_sendmsg_zc(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct msghdr const *") Msghdr msg, @NativeType("unsigned") int flags) {
/* 1537 */     if (Checks.CHECKS) {
/* 1538 */       Msghdr.validate(msg.address());
/*      */     }
/* 1540 */     nio_uring_prep_sendmsg_zc(sqe.address(), fd, msg.address(), flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_sendmsg_zc_fixed(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct msghdr const *") Msghdr msg, @NativeType("unsigned") int flags, @NativeType("unsigned") int buf_index) {
/* 1550 */     if (Checks.CHECKS) {
/* 1551 */       Msghdr.validate(msg.address());
/*      */     }
/* 1553 */     nio_uring_prep_sendmsg_zc_fixed(sqe.address(), fd, msg.address(), flags, buf_index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_recv(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int sockfd, @NativeType("void *") ByteBuffer buf, int flags) {
/* 1563 */     nio_uring_prep_recv(sqe.address(), sockfd, MemoryUtil.memAddress(buf), buf.remaining(), flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_recv_multishot(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int sockfd, @NativeType("void *") ByteBuffer buf, int flags) {
/* 1573 */     nio_uring_prep_recv_multishot(sqe.address(), sockfd, MemoryUtil.memAddress(buf), buf.remaining(), flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("struct io_uring_recvmsg_out *")
/*      */   public static IOURingRecvmsgOut io_uring_recvmsg_validate(@NativeType("void *") ByteBuffer buf, @NativeType("struct msghdr *") Msghdr msgh) {
/* 1584 */     long __result = nio_uring_recvmsg_validate(MemoryUtil.memAddress(buf), buf.remaining(), msgh.address());
/* 1585 */     return IOURingRecvmsgOut.createSafe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static long io_uring_recvmsg_name(@NativeType("struct io_uring_recvmsg_out *") IOURingRecvmsgOut o) {
/* 1596 */     return nio_uring_recvmsg_name(o.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("struct cmsghdr *")
/*      */   public static CMsghdr io_uring_recvmsg_cmsg_firsthdr(@NativeType("struct io_uring_recvmsg_out *") IOURingRecvmsgOut o, @NativeType("struct msghdr *") Msghdr msgh) {
/* 1607 */     long __result = nio_uring_recvmsg_cmsg_firsthdr(o.address(), msgh.address());
/* 1608 */     return CMsghdr.createSafe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("struct cmsghdr *")
/*      */   public static CMsghdr io_uring_recvmsg_cmsg_nexthdr(@NativeType("struct io_uring_recvmsg_out *") IOURingRecvmsgOut o, @NativeType("struct msghdr *") Msghdr msgh, @NativeType("struct cmsghdr *") CMsghdr cmsg) {
/* 1619 */     long __result = nio_uring_recvmsg_cmsg_nexthdr(o.address(), msgh.address(), cmsg.address());
/* 1620 */     return CMsghdr.createSafe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static long io_uring_recvmsg_payload(@NativeType("struct io_uring_recvmsg_out *") IOURingRecvmsgOut o, @NativeType("struct msghdr *") Msghdr msgh) {
/* 1631 */     return nio_uring_recvmsg_payload(o.address(), msgh.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned int")
/*      */   public static int io_uring_recvmsg_payload_length(@NativeType("struct io_uring_recvmsg_out *") IOURingRecvmsgOut o, int buf_len, @NativeType("struct msghdr *") Msghdr msgh) {
/* 1642 */     return nio_uring_recvmsg_payload_length(o.address(), buf_len, msgh.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_openat2(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int dfd, @NativeType("char const *") ByteBuffer path, @NativeType("struct open_how const *") OpenHow how) {
/* 1652 */     if (Checks.CHECKS) {
/* 1653 */       Checks.checkNT1(path);
/*      */     }
/* 1655 */     nio_uring_prep_openat2(sqe.address(), dfd, MemoryUtil.memAddress(path), how.address());
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_openat2(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int dfd, @NativeType("char const *") CharSequence path, @NativeType("struct open_how const *") OpenHow how) {
/* 1660 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1662 */       stack.nUTF8(path, true);
/* 1663 */       long pathEncoded = stack.getPointerAddress();
/* 1664 */       nio_uring_prep_openat2(sqe.address(), dfd, pathEncoded, how.address());
/*      */     } finally {
/* 1666 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_openat2_direct(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int dfd, @NativeType("char const *") ByteBuffer path, @NativeType("struct open_how const *") OpenHow how, @NativeType("unsigned") int file_index) {
/* 1677 */     if (Checks.CHECKS) {
/* 1678 */       Checks.checkNT1(path);
/*      */     }
/* 1680 */     nio_uring_prep_openat2_direct(sqe.address(), dfd, MemoryUtil.memAddress(path), how.address(), file_index);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_openat2_direct(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int dfd, @NativeType("char const *") CharSequence path, @NativeType("struct open_how const *") OpenHow how, @NativeType("unsigned") int file_index) {
/* 1685 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1687 */       stack.nUTF8(path, true);
/* 1688 */       long pathEncoded = stack.getPointerAddress();
/* 1689 */       nio_uring_prep_openat2_direct(sqe.address(), dfd, pathEncoded, how.address(), file_index);
/*      */     } finally {
/* 1691 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_epoll_ctl(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int epfd, int fd, int op, @NativeType("struct epoll_event const *") EpollEvent ev) {
/* 1702 */     nio_uring_prep_epoll_ctl(sqe.address(), epfd, fd, op, ev.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_provide_buffers(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("void *") ByteBuffer addr, int nr, int bgid, int bid) {
/* 1712 */     nio_uring_prep_provide_buffers(sqe.address(), MemoryUtil.memAddress(addr), addr.remaining(), nr, bgid, bid);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_remove_buffers(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int nr, int bgid) {
/* 1722 */     nio_uring_prep_remove_buffers(sqe.address(), nr, bgid);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_shutdown(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, int how) {
/* 1732 */     nio_uring_prep_shutdown(sqe.address(), fd, how);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_unlinkat(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int dfd, @NativeType("char const *") ByteBuffer path, int flags) {
/* 1742 */     if (Checks.CHECKS) {
/* 1743 */       Checks.checkNT1(path);
/*      */     }
/* 1745 */     nio_uring_prep_unlinkat(sqe.address(), dfd, MemoryUtil.memAddress(path), flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_unlinkat(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int dfd, @NativeType("char const *") CharSequence path, int flags) {
/* 1750 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1752 */       stack.nUTF8(path, true);
/* 1753 */       long pathEncoded = stack.getPointerAddress();
/* 1754 */       nio_uring_prep_unlinkat(sqe.address(), dfd, pathEncoded, flags);
/*      */     } finally {
/* 1756 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_unlink(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") ByteBuffer path, int flags) {
/* 1767 */     if (Checks.CHECKS) {
/* 1768 */       Checks.checkNT1(path);
/*      */     }
/* 1770 */     nio_uring_prep_unlink(sqe.address(), MemoryUtil.memAddress(path), flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_unlink(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") CharSequence path, int flags) {
/* 1775 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1777 */       stack.nUTF8(path, true);
/* 1778 */       long pathEncoded = stack.getPointerAddress();
/* 1779 */       nio_uring_prep_unlink(sqe.address(), pathEncoded, flags);
/*      */     } finally {
/* 1781 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_renameat(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int olddfd, @NativeType("char const *") ByteBuffer oldpath, int newdfd, @NativeType("char const *") ByteBuffer newpath, @NativeType("unsigned int") int flags) {
/* 1792 */     if (Checks.CHECKS) {
/* 1793 */       Checks.checkNT1(oldpath);
/* 1794 */       Checks.checkNT1(newpath);
/*      */     } 
/* 1796 */     nio_uring_prep_renameat(sqe.address(), olddfd, MemoryUtil.memAddress(oldpath), newdfd, MemoryUtil.memAddress(newpath), flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_renameat(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int olddfd, @NativeType("char const *") CharSequence oldpath, int newdfd, @NativeType("char const *") CharSequence newpath, @NativeType("unsigned int") int flags) {
/* 1801 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1803 */       stack.nUTF8(oldpath, true);
/* 1804 */       long oldpathEncoded = stack.getPointerAddress();
/* 1805 */       stack.nUTF8(newpath, true);
/* 1806 */       long newpathEncoded = stack.getPointerAddress();
/* 1807 */       nio_uring_prep_renameat(sqe.address(), olddfd, oldpathEncoded, newdfd, newpathEncoded, flags);
/*      */     } finally {
/* 1809 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_rename(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") ByteBuffer oldpath, @NativeType("char const *") ByteBuffer newpath) {
/* 1820 */     if (Checks.CHECKS) {
/* 1821 */       Checks.checkNT1(oldpath);
/* 1822 */       Checks.checkNT1(newpath);
/*      */     } 
/* 1824 */     nio_uring_prep_rename(sqe.address(), MemoryUtil.memAddress(oldpath), MemoryUtil.memAddress(newpath));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_rename(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") CharSequence oldpath, @NativeType("char const *") CharSequence newpath) {
/* 1829 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1831 */       stack.nUTF8(oldpath, true);
/* 1832 */       long oldpathEncoded = stack.getPointerAddress();
/* 1833 */       stack.nUTF8(newpath, true);
/* 1834 */       long newpathEncoded = stack.getPointerAddress();
/* 1835 */       nio_uring_prep_rename(sqe.address(), oldpathEncoded, newpathEncoded);
/*      */     } finally {
/* 1837 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_sync_file_range(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("unsigned") int len, @NativeType("__u64") long offset, int flags) {
/* 1848 */     nio_uring_prep_sync_file_range(sqe.address(), fd, len, offset, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_mkdirat(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int dfd, @NativeType("char const *") ByteBuffer path, int mode) {
/* 1858 */     if (Checks.CHECKS) {
/* 1859 */       Checks.checkNT1(path);
/*      */     }
/* 1861 */     nio_uring_prep_mkdirat(sqe.address(), dfd, MemoryUtil.memAddress(path), mode);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_mkdirat(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int dfd, @NativeType("char const *") CharSequence path, int mode) {
/* 1866 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1868 */       stack.nUTF8(path, true);
/* 1869 */       long pathEncoded = stack.getPointerAddress();
/* 1870 */       nio_uring_prep_mkdirat(sqe.address(), dfd, pathEncoded, mode);
/*      */     } finally {
/* 1872 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_mkdir(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") ByteBuffer path, int mode) {
/* 1883 */     if (Checks.CHECKS) {
/* 1884 */       Checks.checkNT1(path);
/*      */     }
/* 1886 */     nio_uring_prep_mkdir(sqe.address(), MemoryUtil.memAddress(path), mode);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_mkdir(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") CharSequence path, int mode) {
/* 1891 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1893 */       stack.nUTF8(path, true);
/* 1894 */       long pathEncoded = stack.getPointerAddress();
/* 1895 */       nio_uring_prep_mkdir(sqe.address(), pathEncoded, mode);
/*      */     } finally {
/* 1897 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_symlinkat(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") ByteBuffer target, int newdirfd, @NativeType("char const *") ByteBuffer linkpath) {
/* 1908 */     if (Checks.CHECKS) {
/* 1909 */       Checks.checkNT1(target);
/* 1910 */       Checks.checkNT1(linkpath);
/*      */     } 
/* 1912 */     nio_uring_prep_symlinkat(sqe.address(), MemoryUtil.memAddress(target), newdirfd, MemoryUtil.memAddress(linkpath));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_symlinkat(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") CharSequence target, int newdirfd, @NativeType("char const *") CharSequence linkpath) {
/* 1917 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1919 */       stack.nUTF8(target, true);
/* 1920 */       long targetEncoded = stack.getPointerAddress();
/* 1921 */       stack.nUTF8(linkpath, true);
/* 1922 */       long linkpathEncoded = stack.getPointerAddress();
/* 1923 */       nio_uring_prep_symlinkat(sqe.address(), targetEncoded, newdirfd, linkpathEncoded);
/*      */     } finally {
/* 1925 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_symlink(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") ByteBuffer target, @NativeType("char const *") ByteBuffer linkpath) {
/* 1936 */     if (Checks.CHECKS) {
/* 1937 */       Checks.checkNT1(target);
/* 1938 */       Checks.checkNT1(linkpath);
/*      */     } 
/* 1940 */     nio_uring_prep_symlink(sqe.address(), MemoryUtil.memAddress(target), MemoryUtil.memAddress(linkpath));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_symlink(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") CharSequence target, @NativeType("char const *") CharSequence linkpath) {
/* 1945 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1947 */       stack.nUTF8(target, true);
/* 1948 */       long targetEncoded = stack.getPointerAddress();
/* 1949 */       stack.nUTF8(linkpath, true);
/* 1950 */       long linkpathEncoded = stack.getPointerAddress();
/* 1951 */       nio_uring_prep_symlink(sqe.address(), targetEncoded, linkpathEncoded);
/*      */     } finally {
/* 1953 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_linkat(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int olddfd, @NativeType("char const *") ByteBuffer oldpath, int newdfd, @NativeType("char const *") ByteBuffer newpath, int flags) {
/* 1964 */     if (Checks.CHECKS) {
/* 1965 */       Checks.checkNT1(oldpath);
/* 1966 */       Checks.checkNT1(newpath);
/*      */     } 
/* 1968 */     nio_uring_prep_linkat(sqe.address(), olddfd, MemoryUtil.memAddress(oldpath), newdfd, MemoryUtil.memAddress(newpath), flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_linkat(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int olddfd, @NativeType("char const *") CharSequence oldpath, int newdfd, @NativeType("char const *") CharSequence newpath, int flags) {
/* 1973 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1975 */       stack.nUTF8(oldpath, true);
/* 1976 */       long oldpathEncoded = stack.getPointerAddress();
/* 1977 */       stack.nUTF8(newpath, true);
/* 1978 */       long newpathEncoded = stack.getPointerAddress();
/* 1979 */       nio_uring_prep_linkat(sqe.address(), olddfd, oldpathEncoded, newdfd, newpathEncoded, flags);
/*      */     } finally {
/* 1981 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_link(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") ByteBuffer oldpath, @NativeType("char const *") ByteBuffer newpath, int flags) {
/* 1992 */     if (Checks.CHECKS) {
/* 1993 */       Checks.checkNT1(oldpath);
/* 1994 */       Checks.checkNT1(newpath);
/*      */     } 
/* 1996 */     nio_uring_prep_link(sqe.address(), MemoryUtil.memAddress(oldpath), MemoryUtil.memAddress(newpath), flags);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_link(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") CharSequence oldpath, @NativeType("char const *") CharSequence newpath, int flags) {
/* 2001 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2003 */       stack.nUTF8(oldpath, true);
/* 2004 */       long oldpathEncoded = stack.getPointerAddress();
/* 2005 */       stack.nUTF8(newpath, true);
/* 2006 */       long newpathEncoded = stack.getPointerAddress();
/* 2007 */       nio_uring_prep_link(sqe.address(), oldpathEncoded, newpathEncoded, flags);
/*      */     } finally {
/* 2009 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_msg_ring_cqe_flags(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("unsigned int") int len, @NativeType("__u64") long data, @NativeType("unsigned int") int flags, @NativeType("unsigned int") int cqe_flags) {
/* 2020 */     nio_uring_prep_msg_ring_cqe_flags(sqe.address(), fd, len, data, flags, cqe_flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_msg_ring(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("unsigned int") int len, @NativeType("__u64") long data, @NativeType("unsigned int") int flags) {
/* 2030 */     nio_uring_prep_msg_ring(sqe.address(), fd, len, data, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_msg_ring_fd(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, int source_fd, int target_fd, @NativeType("__u64") long data, @NativeType("unsigned int") int flags) {
/* 2040 */     nio_uring_prep_msg_ring_fd(sqe.address(), fd, source_fd, target_fd, data, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_msg_ring_fd_alloc(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, int source_fd, @NativeType("__u64") long data, @NativeType("unsigned int") int flags) {
/* 2050 */     nio_uring_prep_msg_ring_fd_alloc(sqe.address(), fd, source_fd, data, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_getxattr(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") ByteBuffer name, @NativeType("char *") ByteBuffer value, @NativeType("char const *") ByteBuffer path) {
/* 2060 */     if (Checks.CHECKS) {
/* 2061 */       Checks.checkNT1(name);
/* 2062 */       Checks.checkNT1(path);
/*      */     } 
/* 2064 */     nio_uring_prep_getxattr(sqe.address(), MemoryUtil.memAddress(name), MemoryUtil.memAddress(value), MemoryUtil.memAddress(path), value.remaining());
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_getxattr(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") CharSequence name, @NativeType("char *") ByteBuffer value, @NativeType("char const *") CharSequence path) {
/* 2069 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2071 */       stack.nUTF8(name, true);
/* 2072 */       long nameEncoded = stack.getPointerAddress();
/* 2073 */       stack.nUTF8(path, true);
/* 2074 */       long pathEncoded = stack.getPointerAddress();
/* 2075 */       nio_uring_prep_getxattr(sqe.address(), nameEncoded, MemoryUtil.memAddress(value), pathEncoded, value.remaining());
/*      */     } finally {
/* 2077 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_setxattr(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") ByteBuffer name, @NativeType("char const *") ByteBuffer value, @NativeType("char const *") ByteBuffer path, int flags) {
/* 2088 */     if (Checks.CHECKS) {
/* 2089 */       Checks.checkNT1(name);
/* 2090 */       Checks.checkNT1(path);
/*      */     } 
/* 2092 */     nio_uring_prep_setxattr(sqe.address(), MemoryUtil.memAddress(name), MemoryUtil.memAddress(value), MemoryUtil.memAddress(path), flags, value.remaining());
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_setxattr(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("char const *") CharSequence name, @NativeType("char const *") ByteBuffer value, @NativeType("char const *") CharSequence path, int flags) {
/* 2097 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2099 */       stack.nUTF8(name, true);
/* 2100 */       long nameEncoded = stack.getPointerAddress();
/* 2101 */       stack.nUTF8(path, true);
/* 2102 */       long pathEncoded = stack.getPointerAddress();
/* 2103 */       nio_uring_prep_setxattr(sqe.address(), nameEncoded, MemoryUtil.memAddress(value), pathEncoded, flags, value.remaining());
/*      */     } finally {
/* 2105 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_fgetxattr(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("char const *") ByteBuffer name, @NativeType("char *") ByteBuffer value) {
/* 2116 */     if (Checks.CHECKS) {
/* 2117 */       Checks.checkNT1(name);
/*      */     }
/* 2119 */     nio_uring_prep_fgetxattr(sqe.address(), fd, MemoryUtil.memAddress(name), MemoryUtil.memAddress(value), value.remaining());
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_fgetxattr(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("char const *") CharSequence name, @NativeType("char *") ByteBuffer value) {
/* 2124 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2126 */       stack.nUTF8(name, true);
/* 2127 */       long nameEncoded = stack.getPointerAddress();
/* 2128 */       nio_uring_prep_fgetxattr(sqe.address(), fd, nameEncoded, MemoryUtil.memAddress(value), value.remaining());
/*      */     } finally {
/* 2130 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_fsetxattr(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("char const *") ByteBuffer name, @NativeType("char const *") ByteBuffer value, int flags) {
/* 2141 */     if (Checks.CHECKS) {
/* 2142 */       Checks.checkNT1(name);
/*      */     }
/* 2144 */     nio_uring_prep_fsetxattr(sqe.address(), fd, MemoryUtil.memAddress(name), MemoryUtil.memAddress(value), flags, value.remaining());
/*      */   }
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_fsetxattr(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("char const *") CharSequence name, @NativeType("char const *") ByteBuffer value, int flags) {
/* 2149 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2151 */       stack.nUTF8(name, true);
/* 2152 */       long nameEncoded = stack.getPointerAddress();
/* 2153 */       nio_uring_prep_fsetxattr(sqe.address(), fd, nameEncoded, MemoryUtil.memAddress(value), flags, value.remaining());
/*      */     } finally {
/* 2155 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_socket(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int domain, int type, int protocol, @NativeType("unsigned int") int flags) {
/* 2166 */     nio_uring_prep_socket(sqe.address(), domain, type, protocol, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_socket_direct(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int domain, int type, int protocol, @NativeType("unsigned") int file_index, @NativeType("unsigned int") int flags) {
/* 2176 */     nio_uring_prep_socket_direct(sqe.address(), domain, type, protocol, file_index, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_socket_direct_alloc(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int domain, int type, int protocol, @NativeType("unsigned int") int flags) {
/* 2186 */     nio_uring_prep_socket_direct_alloc(sqe.address(), domain, type, protocol, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_uring_cmd(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int cmd_op, int fd) {
/* 2196 */     nio_uring_prep_uring_cmd(sqe.address(), cmd_op, fd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_uring_cmd128(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int cmd_op, int fd) {
/* 2206 */     nio_uring_prep_uring_cmd128(sqe.address(), cmd_op, fd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_cmd_sock(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int cmd_op, int fd, int level, int optname, @NativeType("void *") ByteBuffer optval) {
/* 2216 */     nio_uring_prep_cmd_sock(sqe.address(), cmd_op, fd, level, optname, MemoryUtil.memAddress(optval), optval.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_cmd_getsockname(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("struct sockaddr *") Sockaddr sockaddr, @NativeType("socklen_t *") IntBuffer sockaddr_len, int peer) {
/* 2226 */     if (Checks.CHECKS) {
/* 2227 */       Checks.check(sockaddr_len, 1);
/*      */     }
/* 2229 */     nio_uring_prep_cmd_getsockname(sqe.address(), fd, sockaddr.address(), MemoryUtil.memAddress(sockaddr_len), peer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_waitid(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("idtype_t") int idtype, @NativeType("id_t") int id, @NativeType("siginfo_t *") long infop, int options, @NativeType("unsigned int") int flags) {
/* 2239 */     if (Checks.CHECKS) {
/* 2240 */       Checks.check(infop);
/*      */     }
/* 2242 */     nio_uring_prep_waitid(sqe.address(), idtype, id, infop, options, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_futex_wake(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("uint32_t const *") IntBuffer futex, @NativeType("uint64_t") long val, @NativeType("uint64_t") long mask, @NativeType("uint32_t") int futex_flags, @NativeType("unsigned int") int flags) {
/* 2252 */     if (Checks.CHECKS) {
/* 2253 */       Checks.check(futex, 1);
/*      */     }
/* 2255 */     nio_uring_prep_futex_wake(sqe.address(), MemoryUtil.memAddress(futex), val, mask, futex_flags, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_futex_wait(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("uint32_t const *") IntBuffer futex, @NativeType("uint64_t") long val, @NativeType("uint64_t") long mask, @NativeType("uint32_t") int futex_flags, @NativeType("unsigned int") int flags) {
/* 2265 */     if (Checks.CHECKS) {
/* 2266 */       Checks.check(futex, 1);
/*      */     }
/* 2268 */     nio_uring_prep_futex_wait(sqe.address(), MemoryUtil.memAddress(futex), val, mask, futex_flags, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_futex_waitv(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("struct futex_waitv const *") PointerBuffer futex, @NativeType("unsigned int") int flags) {
/* 2278 */     nio_uring_prep_futex_waitv(sqe.address(), MemoryUtil.memAddress((CustomBuffer)futex), futex.remaining(), flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_fixed_fd_install(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("unsigned int") int flags) {
/* 2288 */     nio_uring_prep_fixed_fd_install(sqe.address(), fd, flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_ftruncate(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("loff_t") long len) {
/* 2298 */     nio_uring_prep_ftruncate(sqe.address(), fd, len);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_cmd_discard(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, int fd, @NativeType("uint64_t") long offset, @NativeType("uint64_t") long nbytes) {
/* 2308 */     nio_uring_prep_cmd_discard(sqe.address(), fd, offset, nbytes);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_pipe(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("int *") IntBuffer fds, int pipe_flags) {
/* 2318 */     if (Checks.CHECKS) {
/* 2319 */       Checks.check(fds, 2);
/*      */     }
/* 2321 */     nio_uring_prep_pipe(sqe.address(), MemoryUtil.memAddress(fds), pipe_flags);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_prep_pipe_direct(@NativeType("struct io_uring_sqe *") IOURingSQE sqe, @NativeType("int *") IntBuffer fds, int pipe_flags, @NativeType("unsigned int") int file_index) {
/* 2331 */     if (Checks.CHECKS) {
/* 2332 */       Checks.check(fds, 2);
/*      */     }
/* 2334 */     nio_uring_prep_pipe_direct(sqe.address(), MemoryUtil.memAddress(fds), pipe_flags, file_index);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned")
/*      */   public static int io_uring_load_sq_head(@NativeType("struct io_uring const *") IOURing ring) {
/* 2345 */     if (Checks.CHECKS) {
/* 2346 */       IOURing.validate(ring.address());
/*      */     }
/* 2348 */     return nio_uring_load_sq_head(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned int")
/*      */   public static int io_uring_sq_ready(@NativeType("struct io_uring const *") IOURing ring) {
/* 2359 */     if (Checks.CHECKS) {
/* 2360 */       IOURing.validate(ring.address());
/*      */     }
/* 2362 */     return nio_uring_sq_ready(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned int")
/*      */   public static int io_uring_sq_space_left(@NativeType("struct io_uring const *") IOURing ring) {
/* 2373 */     if (Checks.CHECKS) {
/* 2374 */       IOURing.validate(ring.address());
/*      */     }
/* 2376 */     return nio_uring_sq_space_left(ring.address());
/*      */   }
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
/*      */   @NativeType("unsigned")
/*      */   public static int io_uring_sqe_shift(@NativeType("struct io_uring const *") IOURing ring) {
/* 2393 */     if (Checks.CHECKS) {
/* 2394 */       IOURing.validate(ring.address());
/*      */     }
/* 2396 */     return nio_uring_sqe_shift(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_sqring_wait(@NativeType("struct io_uring *") IOURing ring) {
/* 2406 */     return nio_uring_sqring_wait(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned int")
/*      */   public static int io_uring_cq_ready(@NativeType("struct io_uring const *") IOURing ring) {
/* 2417 */     if (Checks.CHECKS) {
/* 2418 */       IOURing.validate(ring.address());
/*      */     }
/* 2420 */     return nio_uring_cq_ready(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("bool")
/*      */   public static boolean io_uring_cq_has_overflow(@NativeType("struct io_uring const *") IOURing ring) {
/* 2431 */     if (Checks.CHECKS) {
/* 2432 */       IOURing.validate(ring.address());
/*      */     }
/* 2434 */     return nio_uring_cq_has_overflow(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("bool")
/*      */   public static boolean io_uring_cq_eventfd_enabled(@NativeType("struct io_uring const *") IOURing ring) {
/* 2445 */     if (Checks.CHECKS) {
/* 2446 */       IOURing.validate(ring.address());
/*      */     }
/* 2448 */     return nio_uring_cq_eventfd_enabled(ring.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_cq_eventfd_toggle(@NativeType("struct io_uring *") IOURing ring, @NativeType("bool") boolean enabled) {
/* 2458 */     return nio_uring_cq_eventfd_toggle(ring.address(), enabled);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_wait_cqe_nr(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_cqe **") PointerBuffer cqe_ptr) {
/* 2468 */     return nio_uring_wait_cqe_nr(ring.address(), MemoryUtil.memAddress((CustomBuffer)cqe_ptr), cqe_ptr.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_peek_cqe(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_cqe **") PointerBuffer cqe_ptr) {
/* 2478 */     if (Checks.CHECKS) {
/* 2479 */       Checks.check((CustomBuffer)cqe_ptr, 1);
/*      */     }
/* 2481 */     return nio_uring_peek_cqe(ring.address(), MemoryUtil.memAddress((CustomBuffer)cqe_ptr));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_wait_cqe(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_cqe **") PointerBuffer cqe_ptr) {
/* 2491 */     if (Checks.CHECKS) {
/* 2492 */       Checks.check((CustomBuffer)cqe_ptr, 1);
/*      */     }
/* 2494 */     return nio_uring_wait_cqe(ring.address(), MemoryUtil.memAddress((CustomBuffer)cqe_ptr));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_buf_ring_advance(@NativeType("struct io_uring_buf_ring *") IOURingBufRing br, int count) {
/* 2504 */     nio_uring_buf_ring_advance(br.address(), count);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void io_uring_buf_ring_cq_advance(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_buf_ring *") IOURingBufRing br, int count) {
/* 2514 */     nio_uring_buf_ring_cq_advance(ring.address(), br.address(), count);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int io_uring_buf_ring_available(@NativeType("struct io_uring *") IOURing ring, @NativeType("struct io_uring_buf_ring *") IOURingBufRing br, @NativeType("unsigned short") short bgid) {
/* 2524 */     return nio_uring_buf_ring_available(ring.address(), br.address(), bgid);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("struct io_uring_sqe *")
/*      */   public static IOURingSQE io_uring_get_sqe(@NativeType("struct io_uring *") IOURing ring) {
/* 2535 */     long __result = nio_uring_get_sqe(ring.address());
/* 2536 */     return IOURingSQE.createSafe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("struct io_uring_sqe *")
/*      */   public static IOURingSQE io_uring_get_sqe128(@NativeType("struct io_uring *") IOURing ring) {
/* 2547 */     long __result = nio_uring_get_sqe128(ring.address());
/* 2548 */     return IOURingSQE.createSafe(__result);
/*      */   }
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
/*      */   public static int io_uring_mlock_size_params(@NativeType("unsigned") int entries, @NativeType("struct io_uring_params *") IOURingParams p) {
/* 2563 */     return nio_uring_mlock_size_params(entries, p.address());
/*      */   }
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
/*      */   @NativeType("ssize_t")
/*      */   public static long io_uring_memory_size_params(@NativeType("unsigned") int entries, @NativeType("struct io_uring_params *") IOURingParams p) {
/* 2580 */     return nio_uring_memory_size_params(entries, p.address());
/*      */   }
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
/*      */   public static int io_uring_buf_ring_mask(@NativeType("__u32") int ring_entries) {
/* 2601 */     return ring_entries - 1;
/*      */   }
/*      */   
/*      */   public static void io_uring_buf_ring_init(@NativeType("struct io_uring_buf_ring *") IOURingBufRing br) {
/* 2605 */     br.tail((short)0);
/*      */   }
/*      */   
/*      */   public static void io_uring_buf_ring_add(@NativeType("struct io_uring_buf_ring *") IOURingBufRing br, @NativeType("void *") ByteBuffer addr, @NativeType("unsigned short") short bid, int mask, int buf_offset) {
/* 2609 */     IOURingBuf buf = br.bufs(br.tail() + buf_offset & mask);
/*      */     
/* 2611 */     buf.addr(MemoryUtil.memAddress(addr));
/* 2612 */     buf.len(addr.remaining());
/* 2613 */     buf.bid(bid);
/*      */   }
/*      */   
/*      */   public static native long nio_uring_get_probe_ring(long paramLong);
/*      */   
/*      */   public static native long nio_uring_get_probe();
/*      */   
/*      */   public static native void nio_uring_free_probe(long paramLong);
/*      */   
/*      */   public static native int nio_uring_opcode_supported(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nio_uring_queue_init_mem(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int nio_uring_queue_init_params(int paramInt, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_queue_init(int paramInt1, long paramLong, int paramInt2);
/*      */   
/*      */   public static native int nio_uring_queue_mmap(int paramInt, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_ring_dontfork(long paramLong);
/*      */   
/*      */   public static native void nio_uring_queue_exit(long paramLong);
/*      */   
/*      */   public static native int nio_uring_peek_batch_cqe(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nio_uring_wait_cqes(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int nio_uring_wait_cqes_min_timeout(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4);
/*      */   
/*      */   public static native int nio_uring_wait_cqe_timeout(long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int nio_uring_submit(long paramLong);
/*      */   
/*      */   public static native int nio_uring_submit_and_wait(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nio_uring_submit_and_wait_timeout(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int nio_uring_submit_and_wait_min_timeout(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, long paramLong4);
/*      */   
/*      */   public static native int nio_uring_submit_and_wait_reg(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native int nio_uring_register_wait_reg(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nio_uring_resize_rings(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_clone_buffers_offset(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native int nio_uring_clone_buffers(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_register_buffers(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_buffers_tags(long paramLong1, long paramLong2, long paramLong3, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_buffers_sparse(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_buffers_update_tag(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native int nio_uring_unregister_buffers(long paramLong);
/*      */   
/*      */   public static native int nio_uring_register_files(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_files_tags(long paramLong1, long paramLong2, long paramLong3, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_files_sparse(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_files_update_tag(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native int nio_uring_unregister_files(long paramLong);
/*      */   
/*      */   public static native int nio_uring_register_files_update(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native int nio_uring_register_eventfd(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_eventfd_async(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nio_uring_unregister_eventfd(long paramLong);
/*      */   
/*      */   public static native int nio_uring_register_probe(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_personality(long paramLong);
/*      */   
/*      */   public static native int nio_uring_unregister_personality(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nio_uring_register_restrictions(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nio_uring_enable_rings(long paramLong);
/*      */   
/*      */   public static native int n__io_uring_sqring_wait(long paramLong);
/*      */   
/*      */   public static native int nio_uring_register_iowq_aff(long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int nio_uring_unregister_iowq_aff(long paramLong);
/*      */   
/*      */   public static native int nio_uring_register_iowq_max_workers(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_register_ring_fd(long paramLong);
/*      */   
/*      */   public static native int nio_uring_unregister_ring_fd(long paramLong);
/*      */   
/*      */   public static native int nio_uring_close_ring_fd(long paramLong);
/*      */   
/*      */   public static native int nio_uring_register_buf_ring(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nio_uring_unregister_buf_ring(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nio_uring_buf_ring_head(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_register_sync_cancel(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_register_file_alloc_range(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native int nio_uring_register_napi(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_unregister_napi(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_register_ifq(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_register_clock(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_get_events(long paramLong);
/*      */   
/*      */   public static native int nio_uring_submit_and_get_events(long paramLong);
/*      */   
/*      */   public static native int nio_uring_enter(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native int nio_uring_enter2(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_setup(int paramInt, long paramLong);
/*      */   
/*      */   public static native int io_uring_register(@NativeType("unsigned int") int paramInt1, @NativeType("unsigned int") int paramInt2, @NativeType("void *") long paramLong, @NativeType("unsigned int") int paramInt3);
/*      */   
/*      */   public static native int nio_uring_register_region(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native long nio_uring_setup_buf_ring(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_free_buf_ring(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native int nio_uring_set_iowait(long paramLong, boolean paramBoolean);
/*      */   
/*      */   @NativeType("unsigned")
/*      */   public static native int io_uring_cqe_shift_from_flags(@NativeType("unsigned") int paramInt);
/*      */   
/*      */   public static native int nio_uring_cqe_shift(long paramLong);
/*      */   
/*      */   public static native int nio_uring_cqe_nr(long paramLong);
/*      */   
/*      */   public static native void nio_uring_cq_advance(long paramLong, int paramInt);
/*      */   
/*      */   public static native void nio_uring_cqe_seen(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nio_uring_sqe_set_data(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native long nio_uring_cqe_get_data(long paramLong);
/*      */   
/*      */   public static native void nio_uring_sqe_set_data64(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native long nio_uring_cqe_get_data64(long paramLong);
/*      */   
/*      */   public static native void nio_uring_sqe_set_flags(long paramLong, int paramInt);
/*      */   
/*      */   public static native void nio_uring_sqe_set_buf_group(long paramLong, int paramInt);
/*      */   
/*      */   public static native void nio_uring_initialize_sqe(long paramLong);
/*      */   
/*      */   public static native void nio_uring_prep_splice(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_tee(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_readv(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_readv2(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_read_fixed(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_readv_fixed(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_writev(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3);
/*      */   
/*      */   public static native void nio_uring_prep_writev2(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_write_fixed(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_writev_fixed(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_recvmsg(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_recvmsg_multishot(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_sendmsg(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_poll_add(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_poll_multishot(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_poll_remove(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nio_uring_prep_poll_update(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_fsync(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_nop(long paramLong);
/*      */   
/*      */   public static native void nio_uring_prep_nop128(long paramLong);
/*      */   
/*      */   public static native void nio_uring_prep_timeout(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_timeout_remove(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_timeout_update(long paramLong1, long paramLong2, long paramLong3, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_accept(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_accept_direct(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_multishot_accept(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_multishot_accept_direct(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_cancel64(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_cancel(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_cancel_fd(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_link_timeout(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_connect(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_bind(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_listen(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_epoll_wait(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_files_update(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_fallocate(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nio_uring_prep_openat(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_openat_direct(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_open(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_open_direct(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_close(long paramLong, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_close_direct(long paramLong, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_read(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3);
/*      */   
/*      */   public static native void nio_uring_prep_read_multishot(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_write(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3);
/*      */   
/*      */   public static native void nio_uring_prep_statx(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, long paramLong3);
/*      */   
/*      */   public static native void nio_uring_prep_fadvise(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_madvise(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_fadvise64(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_madvise64(long paramLong1, long paramLong2, long paramLong3, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_send(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_send_bundle(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_send_set_addr(long paramLong1, long paramLong2, short paramShort);
/*      */   
/*      */   public static native void nio_uring_prep_sendto(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_send_zc(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_send_zc_fixed(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_sendmsg_zc(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_sendmsg_zc_fixed(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_recv(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_recv_multishot(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native long nio_uring_recvmsg_validate(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native long nio_uring_recvmsg_name(long paramLong);
/*      */   
/*      */   public static native long nio_uring_recvmsg_cmsg_firsthdr(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native long nio_uring_recvmsg_cmsg_nexthdr(long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native long nio_uring_recvmsg_payload(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_recvmsg_payload_length(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native void nio_uring_prep_openat2(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nio_uring_prep_openat2_direct(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_epoll_ctl(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
/*      */   
/*      */   public static native void nio_uring_prep_provide_buffers(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_remove_buffers(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_shutdown(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_unlinkat(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_unlink(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_renameat(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_rename(long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nio_uring_prep_sync_file_range(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_mkdirat(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_mkdir(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_symlinkat(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*      */   
/*      */   public static native void nio_uring_prep_symlink(long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nio_uring_prep_linkat(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_link(long paramLong1, long paramLong2, long paramLong3, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_msg_ring_cqe_flags(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_msg_ring(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_msg_ring_fd(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_msg_ring_fd_alloc(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_getxattr(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_setxattr(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_fgetxattr(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_fsetxattr(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, int paramInt3);
/*      */   
/*      */   public static native void nio_uring_prep_socket(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_socket_direct(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*      */   
/*      */   public static native void nio_uring_prep_socket_direct_alloc(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_uring_cmd(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_uring_cmd128(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_cmd_sock(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, int paramInt5);
/*      */   
/*      */   public static native void nio_uring_prep_cmd_getsockname(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_waitid(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4);
/*      */   
/*      */   public static native void nio_uring_prep_futex_wake(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_futex_wait(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_futex_waitv(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_fixed_fd_install(long paramLong, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native void nio_uring_prep_ftruncate(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native void nio_uring_prep_cmd_discard(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nio_uring_prep_pipe(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native void nio_uring_prep_pipe_direct(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
/*      */   
/*      */   public static native int nio_uring_load_sq_head(long paramLong);
/*      */   
/*      */   public static native int nio_uring_sq_ready(long paramLong);
/*      */   
/*      */   public static native int nio_uring_sq_space_left(long paramLong);
/*      */   
/*      */   @NativeType("unsigned")
/*      */   public static native int io_uring_sqe_shift_from_flags(@NativeType("unsigned") int paramInt);
/*      */   
/*      */   public static native int nio_uring_sqe_shift(long paramLong);
/*      */   
/*      */   public static native int nio_uring_sqring_wait(long paramLong);
/*      */   
/*      */   public static native int nio_uring_cq_ready(long paramLong);
/*      */   
/*      */   public static native boolean nio_uring_cq_has_overflow(long paramLong);
/*      */   
/*      */   public static native boolean nio_uring_cq_eventfd_enabled(long paramLong);
/*      */   
/*      */   public static native int nio_uring_cq_eventfd_toggle(long paramLong, boolean paramBoolean);
/*      */   
/*      */   public static native int nio_uring_wait_cqe_nr(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nio_uring_peek_cqe(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nio_uring_wait_cqe(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nio_uring_buf_ring_advance(long paramLong, int paramInt);
/*      */   
/*      */   public static native void nio_uring_buf_ring_cq_advance(long paramLong1, long paramLong2, int paramInt);
/*      */   
/*      */   public static native int nio_uring_buf_ring_available(long paramLong1, long paramLong2, short paramShort);
/*      */   
/*      */   public static native long nio_uring_get_sqe(long paramLong);
/*      */   
/*      */   public static native long nio_uring_get_sqe128(long paramLong);
/*      */   
/*      */   public static native int io_uring_mlock_size(@NativeType("unsigned") int paramInt1, @NativeType("unsigned") int paramInt2);
/*      */   
/*      */   public static native int nio_uring_mlock_size_params(int paramInt, long paramLong);
/*      */   
/*      */   @NativeType("ssize_t")
/*      */   public static native long io_uring_memory_size(@NativeType("unsigned") int paramInt1, @NativeType("unsigned") int paramInt2);
/*      */   
/*      */   public static native long nio_uring_memory_size_params(int paramInt, long paramLong);
/*      */   
/*      */   public static native int io_uring_major_version();
/*      */   
/*      */   public static native int io_uring_minor_version();
/*      */   
/*      */   @NativeType("bool")
/*      */   public static native boolean io_uring_check_version(int paramInt1, int paramInt2);
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\LibURing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */