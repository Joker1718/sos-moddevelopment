/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.util.function.Function;
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
/*     */ public class Configuration<T>
/*     */ {
/*  30 */   public static final Configuration<String> LIBRARY_PATH = new Configuration("org.lwjgl.librarypath", (StateInit)StateInit.STRING);
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
/*  49 */   public static final Configuration<Object> BUNDLED_LIBRARY_NAME_MAPPER = new Configuration("org.lwjgl.system.bundledLibrary.nameMapper", (StateInit)StateInit.STRING);
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
/*  69 */   public static final Configuration<Object> BUNDLED_LIBRARY_PATH_MAPPER = new Configuration("org.lwjgl.system.bundledLibrary.pathMapper", (StateInit)StateInit.STRING);
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
/*  81 */   public static final Configuration<String> SHARED_LIBRARY_EXTRACT_DIRECTORY = new Configuration("org.lwjgl.system.SharedLibraryExtractDirectory", (StateInit)StateInit.STRING);
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
/* 108 */   public static final Configuration<String> SHARED_LIBRARY_EXTRACT_PATH = new Configuration("org.lwjgl.system.SharedLibraryExtractPath", (StateInit)StateInit.STRING);
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
/* 121 */   public static final Configuration<Boolean> SHARED_LIBRARY_EXTRACT_FORCE = new Configuration("org.lwjgl.system.SharedLibraryExtractForce", (StateInit)StateInit.BOOLEAN);
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
/* 133 */   public static final Configuration<Boolean> EMULATE_SYSTEM_LOADLIBRARY = new Configuration("org.lwjgl.system.EmulateSystemLoadLibrary", (StateInit)StateInit.BOOLEAN);
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
/* 147 */   public static final Configuration<String> LIBRARY_NAME = new Configuration("org.lwjgl.libname", (StateInit)StateInit.STRING);
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
/* 171 */   public static final Configuration<Object> MEMORY_ALLOCATOR = new Configuration("org.lwjgl.system.allocator", (StateInit)StateInit.STRING);
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
/* 182 */   public static final Configuration<Integer> STACK_SIZE = new Configuration("org.lwjgl.system.stackSize", (StateInit)StateInit.INT);
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
/* 196 */   public static final Configuration<Integer> ARRAY_TLC_SIZE = new Configuration("org.lwjgl.system.arrayTLCSize", (StateInit)StateInit.INT);
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
/* 217 */   public static final Configuration<Integer> JNI_NATIVE_INTERFACE_FUNCTION_COUNT = new Configuration("org.lwjgl.system.JNINativeInterfaceSize", (StateInit)StateInit.INT);
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
/* 229 */   public static final Configuration<Boolean> DISABLE_CHECKS = new Configuration("org.lwjgl.util.NoChecks", (StateInit)StateInit.BOOLEAN);
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
/* 241 */   public static final Configuration<Boolean> DISABLE_FUNCTION_CHECKS = new Configuration("org.lwjgl.util.NoFunctionChecks", (StateInit)StateInit.BOOLEAN);
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
/* 255 */   public static final Configuration<Boolean> DISABLE_HASH_CHECKS = new Configuration("org.lwjgl.util.NoHashChecks", (StateInit)StateInit.BOOLEAN);
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
/* 267 */   public static final Configuration<Boolean> DEBUG = new Configuration("org.lwjgl.util.Debug", (StateInit)StateInit.BOOLEAN);
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
/* 278 */   public static final Configuration<Boolean> DEBUG_LOADER = new Configuration("org.lwjgl.util.DebugLoader", (StateInit)StateInit.BOOLEAN);
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
/* 289 */   public static final Configuration<Boolean> DEBUG_GENERATOR = new Configuration("org.lwjgl.util.DebugGenerator", (StateInit)StateInit.BOOLEAN);
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
/* 304 */   public static final Configuration<Object> DEBUG_STREAM = new Configuration("org.lwjgl.util.DebugStream", (StateInit)StateInit.STRING);
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
/* 319 */   public static final Configuration<Boolean> DEBUG_MEMORY_ALLOCATOR = new Configuration("org.lwjgl.util.DebugAllocator", (StateInit)StateInit.BOOLEAN);
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
/* 330 */   public static final Configuration<Boolean> DEBUG_MEMORY_ALLOCATOR_INTERNAL = new Configuration("org.lwjgl.util.DebugAllocator.internal", (StateInit)StateInit.BOOLEAN);
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
/* 351 */   public static final Configuration<Boolean> DEBUG_MEMORY_ALLOCATOR_FAST = new Configuration("org.lwjgl.util.DebugAllocator.fast", (StateInit)StateInit.BOOLEAN);
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
/* 366 */   public static final Configuration<Boolean> DEBUG_STACK = new Configuration("org.lwjgl.util.DebugStack", (StateInit)StateInit.BOOLEAN);
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
/* 379 */   public static final Configuration<Boolean> DEBUG_FUNCTIONS = new Configuration("org.lwjgl.util.DebugFunctions", (StateInit)StateInit.BOOLEAN);
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
/* 410 */   public static final Configuration<Object> FFM_DEFAULT_NULLABLE_ANNOTATION = new Configuration("org.lwjgl.system.ffm.nullable", (StateInit)StateInit.STRING);
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
/* 436 */   public static final Configuration<String> FFM_UPCALL_ARENA = new Configuration("org.lwjgl.system.ffm.upcall.arena", (StateInit)StateInit.STRING);
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
/* 450 */   public static final Configuration<Boolean> FFM_UPCALL_EXCEPTION_CATCH = new Configuration("org.lwjgl.system.ffm.upcall.exception.catch", (StateInit)StateInit.BOOLEAN);
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
/* 468 */   public static final Configuration<Object> FFM_UPCALL_EXCEPTION_HANDLER = new Configuration("org.lwjgl.system.ffm.upcall.exception.handler", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 473 */   public static final Configuration<String> ASSIMP_LIBRARY_NAME = new Configuration("org.lwjgl.assimp.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 476 */   public static final Configuration<String> ASSIMP_DRACO_LIBRARY_NAME = new Configuration("org.lwjgl.assimp.draco.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 481 */   public static final Configuration<String> BGFX_LIBRARY_NAME = new Configuration("org.lwjgl.bgfx.libname", (StateInit)StateInit.STRING);
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
/* 494 */   public static final Configuration<Boolean> EGL_EXPLICIT_INIT = new Configuration("org.lwjgl.egl.explicitInit", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */   
/* 497 */   public static final Configuration<String> EGL_LIBRARY_NAME = new Configuration("org.lwjgl.egl.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/*     */   public static String[] EGL_LIBRARY_NAME_DEFAULTS() {
/* 501 */     switch (Platform.get()) {
/*     */       case FREEBSD:
/*     */       case LINUX:
/* 504 */         return new String[] { "libEGL.so.1" };
/*     */       case MACOSX:
/* 506 */         return new String[] { "EGL" };
/*     */       case WINDOWS:
/* 508 */         return new String[] { "libEGL", "EGL" };
/*     */     } 
/* 510 */     throw new IllegalStateException();
/*     */   }
/*     */ 
/*     */   
/* 514 */   public static final Configuration<Object> EGL_EXTENSION_FILTER = new Configuration("org.lwjgl.egl.extensionFilter", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 519 */   public static final Configuration<String> FMOD_LIBRARY_NAME = new Configuration("org.lwjgl.fmod.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 522 */   public static final Configuration<String> FMOD_STUDIO_LIBRARY_NAME = new Configuration("org.lwjgl.fmod.studio.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 525 */   public static final Configuration<String> FMOD_FSBANK_LIBRARY_NAME = new Configuration("org.lwjgl.fmod.fsbank.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */   
/* 529 */   public static final Configuration<String> FREETYPE_LIBRARY_NAME = new Configuration("org.lwjgl.freetype.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 534 */   public static final Configuration<String> GLFW_LIBRARY_NAME = new Configuration("org.lwjgl.glfw.libname", (StateInit)StateInit.STRING);
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
/* 548 */   public static final Configuration<Boolean> GLFW_CHECK_THREAD0 = new Configuration("org.lwjgl.glfw.checkThread0", (StateInit)StateInit.BOOLEAN);
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
/* 572 */   public static final Configuration<Object> HARFBUZZ_LIBRARY_NAME = new Configuration("org.lwjgl.harfbuzz.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 577 */   public static final Configuration<String> HWLOC_LIBRARY_NAME = new Configuration("org.lwjgl.hwloc.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 582 */   public static final Configuration<String> JAWT_LIBRARY_NAME = new Configuration("org.lwjgl.system.jawt.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 587 */   public static final Configuration<String> JEMALLOC_LIBRARY_NAME = new Configuration("org.lwjgl.system.jemalloc.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 592 */   public static final Configuration<String> KTX_LIBRARY_NAME = new Configuration("org.lwjgl.ktx.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 597 */   public static final Configuration<String> LLVM_LIBRARY_NAME = new Configuration("org.lwjgl.llvm.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 600 */   public static final Configuration<String> LLVM_CLANG_LIBRARY_NAME = new Configuration("org.lwjgl.llvm.clang.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 603 */   public static final Configuration<String> LLVM_LTO_LIBRARY_NAME = new Configuration("org.lwjgl.llvm.lto.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 613 */   public static final Configuration<Boolean> NFD_LINUX_PORTAL = new Configuration("org.lwjgl.nfd.linux.portal", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 618 */   public static final Configuration<String> ODBC_LIBRARY_NAME = new Configuration("org.lwjgl.odbc.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 623 */   public static final Configuration<Boolean> OPENAL_EXPLICIT_INIT = new Configuration("org.lwjgl.openal.explicitInit", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */   
/* 626 */   public static final Configuration<String> OPENAL_LIBRARY_NAME = new Configuration("org.lwjgl.openal.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 629 */   public static final Configuration<Object> OPENAL_EXTENSION_FILTER = new Configuration("org.lwjgl.openal.extensionFilter", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 634 */   public static final Configuration<Boolean> OPENCL_EXPLICIT_INIT = new Configuration("org.lwjgl.opencl.explicitInit", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */   
/* 637 */   public static final Configuration<String> OPENCL_LIBRARY_NAME = new Configuration("org.lwjgl.opencl.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 640 */   public static final Configuration<Object> OPENCL_EXTENSION_FILTER = new Configuration("org.lwjgl.opencl.extensionFilter", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 645 */   public static final Configuration<Boolean> OPENGL_EXPLICIT_INIT = new Configuration("org.lwjgl.opengl.explicitInit", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */   
/* 648 */   public static final Configuration<String> OPENGL_LIBRARY_NAME = new Configuration("org.lwjgl.opengl.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/*     */   public static String[] OPENGL_LIBRARY_NAME_DEFAULTS() {
/* 652 */     switch (Platform.get()) {
/*     */       case FREEBSD:
/*     */       case LINUX:
/* 655 */         return new String[] { "libGLX.so.0", "libGL.so.1", "libGL.so" };
/*     */       case MACOSX:
/* 657 */         return new String[] { "/System/Library/Frameworks/OpenGL.framework/Versions/Current/OpenGL" };
/*     */       case WINDOWS:
/* 659 */         return new String[] { "opengl32" };
/*     */     } 
/* 661 */     throw new IllegalStateException();
/*     */   }
/*     */ 
/*     */   
/* 665 */   public static final Configuration<String> OPENGL_OSMESA_LIBRARY_NAME = new Configuration("org.lwjgl.opengl.osmesa.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/*     */   public static String[] OPENGL_OSMESA_LIBRARY_NAME_DEFAULTS() {
/* 669 */     switch (Platform.get()) {
/*     */       case FREEBSD:
/*     */       case LINUX:
/* 672 */         return new String[] { "libOSMesa.so.8", "libOSMesa.so.6", "libOSMesa.so" };
/*     */       case MACOSX:
/* 674 */         return new String[] { "libOSMesa.8.dylib" };
/*     */       case WINDOWS:
/* 676 */         return new String[] { "libOSMesa", "OSMesa" };
/*     */     } 
/* 678 */     throw new IllegalStateException();
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
/* 693 */   public static final Configuration<Object> OPENGL_MAXVERSION = new Configuration("org.lwjgl.opengl.maxVersion", (StateInit)StateInit.STRING);
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
/* 710 */   public static final Configuration<Object> OPENGL_EXTENSION_FILTER = new Configuration("org.lwjgl.opengl.extensionFilter", (StateInit)StateInit.STRING);
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
/* 733 */   public static final Configuration<String> OPENGL_CONTEXT_API = new Configuration("org.lwjgl.opengl.contextAPI", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 738 */   public static final Configuration<Boolean> OPENGLES_EXPLICIT_INIT = new Configuration("org.lwjgl.opengles.explicitInit", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */   
/* 741 */   public static final Configuration<String> OPENGLES_LIBRARY_NAME = new Configuration("org.lwjgl.opengles.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/*     */   public static String[] OPENGLES_LIBRARY_NAME_DEFAULTS() {
/* 745 */     switch (Platform.get()) {
/*     */       case FREEBSD:
/*     */       case LINUX:
/* 748 */         return new String[] { "libGLESv2.so.2" };
/*     */       case MACOSX:
/* 750 */         return new String[] { "GLESv2" };
/*     */       case WINDOWS:
/* 752 */         return new String[] { "libGLESv2", "GLESv2" };
/*     */     } 
/* 754 */     throw new IllegalStateException();
/*     */   }
/*     */ 
/*     */   
/* 758 */   public static final Configuration<Object> OPENGLES_MAXVERSION = new Configuration("org.lwjgl.opengles.maxVersion", (StateInit)StateInit.STRING);
/*     */ 
/*     */   
/* 761 */   public static final Configuration<Object> OPENGLES_EXTENSION_FILTER = new Configuration("org.lwjgl.opengles.extensionFilter", (StateInit)StateInit.STRING);
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
/* 781 */   public static final Configuration<String> OPENGLES_CONTEXT_API = new Configuration("org.lwjgl.opengles.contextAPI", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 786 */   public static final Configuration<Boolean> OPENXR_EXPLICIT_INIT = new Configuration("org.lwjgl.openxr.explicitInit", (StateInit)StateInit.BOOLEAN);
/*     */ 
/*     */   
/* 789 */   public static final Configuration<String> OPENXR_LIBRARY_NAME = new Configuration("org.lwjgl.openxr.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 794 */   public static final Configuration<String> OPUS_LIBRARY_NAME = new Configuration("org.lwjgl.opus.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 799 */   public static final Configuration<String> RENDERDOC_LIBRARY_NAME = new Configuration("org.lwjgl.renderdoc.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 804 */   public static final Configuration<String> SDL_LIBRARY_NAME = new Configuration("org.lwjgl.sdl.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 809 */   public static final Configuration<String> SHADERC_LIBRARY_NAME = new Configuration("org.lwjgl.shaderc.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 817 */   public static final Configuration<String> GLSLANG_LIBRARY_NAME = new Configuration("org.lwjgl.shaderc.glslang.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 825 */   public static final Configuration<String> GLSLANG_RESOURCE_LIBRARY_NAME = new Configuration("org.lwjgl.shaderc.glslang_resource.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 833 */   public static final Configuration<String> SPIRV_TOOLS_LIBRARY_NAME = new Configuration("org.lwjgl.shaderc.spirv_tools.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 841 */   public static final Configuration<String> SPIRV_TOOLS_OPTIMIZER_LIBRARY_NAME = new Configuration("org.lwjgl.shaderc.spirv_tools_optimizer.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 846 */   public static final Configuration<String> SPVC_LIBRARY_NAME = new Configuration("org.lwjgl.spvc.libname", (StateInit)StateInit.STRING);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 851 */   public static final Configuration<Boolean> VULKAN_EXPLICIT_INIT = new Configuration("org.lwjgl.vulkan.explicitInit", (StateInit)StateInit.BOOLEAN);
/*     */   private final String property;
/*     */   private volatile T state;
/* 854 */   public static final Configuration<String> VULKAN_LIBRARY_NAME = new Configuration("org.lwjgl.vulkan.libname", (StateInit)StateInit.STRING);
/*     */   
/*     */   private static interface StateInit<T> extends Function<String, T> { static {
/* 857 */       BOOLEAN = (property -> {
/*     */           String value = System.getProperty(property);
/*     */           return (value == null) ? null : Boolean.valueOf(Boolean.parseBoolean(value));
/*     */         });
/*     */     }
/* 862 */     public static final StateInit<Integer> INT = Integer::getInteger;
/*     */     public static final StateInit<Boolean> BOOLEAN;
/* 864 */     public static final StateInit<String> STRING = System::getProperty; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Configuration(String property, StateInit<? extends T> init) {
/* 872 */     this.property = property;
/* 873 */     this.state = init.apply(property);
/*     */   }
/*     */   
/*     */   public String getProperty() {
/* 877 */     return this.property;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(T value) {
/* 886 */     this.state = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T get() {
/* 895 */     return this.state;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T get(T defaultValue) {
/* 906 */     T state = this.state;
/* 907 */     if (state == null) {
/* 908 */       state = defaultValue;
/*     */     }
/*     */     
/* 911 */     return state;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\Configuration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */