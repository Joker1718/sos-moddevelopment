/*      */ package org.lwjgl.system.macosx;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.APIUtil;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.FunctionProvider;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ public class ObjCRuntime {
/*      */   public static final long nil = 0L;
/*      */   public static final byte YES = 1;
/*      */   public static final byte NO = 0;
/*      */   public static final char _C_ID = '@';
/*      */   public static final char _C_CLASS = '#';
/*      */   public static final char _C_SEL = ':';
/*      */   public static final char _C_CHR = 'c';
/*      */   public static final char _C_UCHR = 'C';
/*      */   public static final char _C_SHT = 's';
/*   24 */   private static final SharedLibrary OBJC = Library.loadNative(ObjCRuntime.class, "org.lwjgl", "objc"); public static final char _C_USHT = 'S'; public static final char _C_INT = 'i'; public static final char _C_UINT = 'I'; public static final char _C_LNG = 'l'; public static final char _C_ULNG = 'L'; public static final char _C_LNG_LNG = 'q'; public static final char _C_ULNG_LNG = 'Q'; public static final char _C_FLT = 'f'; public static final char _C_DBL = 'd'; public static final char _C_BFLD = 'b'; public static final char _C_BOOL = 'B'; public static final char _C_VOID = 'v'; public static final char _C_UNDEF = '?'; public static final char _C_PTR = '^'; public static final char _C_CHARPTR = '*'; public static final char _C_ATOM = '%'; public static final char _C_ARY_B = '['; public static final char _C_ARY_E = ']'; public static final char _C_UNION_B = '('; public static final char _C_UNION_E = ')'; public static final char _C_STRUCT_B = '{'; public static final char _C_STRUCT_E = '}';
/*      */   public static final char _C_VECTOR = '!';
/*      */   public static final char _C_CONST = 'r';
/*      */   public static final int OBJC_ASSOCIATION_ASSIGN = 0;
/*      */   public static final int OBJC_ASSOCIATION_RETAIN_NONATOMIC = 1;
/*      */   public static final int OBJC_ASSOCIATION_COPY_NONATOMIC = 3;
/*      */   public static final int OBJC_ASSOCIATION_RETAIN = 1401;
/*      */   public static final int OBJC_ASSOCIATION_COPY = 1403;
/*      */   
/*   33 */   public static final class Functions { public static final long object_copy = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_copy");
/*   34 */     public static final long object_dispose = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_dispose");
/*   35 */     public static final long object_getClass = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_getClass");
/*   36 */     public static final long object_setClass = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_setClass");
/*   37 */     public static final long object_getClassName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_getClassName");
/*   38 */     public static final long object_getIndexedIvars = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_getIndexedIvars");
/*   39 */     public static final long object_getIvar = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_getIvar");
/*   40 */     public static final long object_setIvar = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_setIvar");
/*   41 */     public static final long object_setInstanceVariable = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_setInstanceVariable");
/*   42 */     public static final long object_getInstanceVariable = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "object_getInstanceVariable");
/*   43 */     public static final long objc_getClass = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_getClass");
/*   44 */     public static final long objc_getMetaClass = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_getMetaClass");
/*   45 */     public static final long objc_lookUpClass = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_lookUpClass");
/*   46 */     public static final long objc_getRequiredClass = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_getRequiredClass");
/*   47 */     public static final long objc_getClassList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_getClassList");
/*   48 */     public static final long objc_copyClassList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_copyClassList");
/*   49 */     public static final long class_getName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getName");
/*   50 */     public static final long class_isMetaClass = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_isMetaClass");
/*   51 */     public static final long class_getSuperclass = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getSuperclass");
/*   52 */     public static final long class_getVersion = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getVersion");
/*   53 */     public static final long class_setVersion = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_setVersion");
/*   54 */     public static final long class_getInstanceSize = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getInstanceSize");
/*   55 */     public static final long class_getInstanceVariable = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getInstanceVariable");
/*   56 */     public static final long class_getClassVariable = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getClassVariable");
/*   57 */     public static final long class_copyIvarList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_copyIvarList");
/*   58 */     public static final long class_getInstanceMethod = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getInstanceMethod");
/*   59 */     public static final long class_getClassMethod = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getClassMethod");
/*   60 */     public static final long class_getMethodImplementation = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getMethodImplementation");
/*   61 */     public static final long class_respondsToSelector = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_respondsToSelector");
/*   62 */     public static final long class_copyMethodList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_copyMethodList");
/*   63 */     public static final long class_conformsToProtocol = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_conformsToProtocol");
/*   64 */     public static final long class_copyProtocolList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_copyProtocolList");
/*   65 */     public static final long class_getProperty = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getProperty");
/*   66 */     public static final long class_copyPropertyList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_copyPropertyList");
/*   67 */     public static final long class_getIvarLayout = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getIvarLayout");
/*   68 */     public static final long class_getWeakIvarLayout = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getWeakIvarLayout");
/*   69 */     public static final long class_addMethod = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_addMethod");
/*   70 */     public static final long class_replaceMethod = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_replaceMethod");
/*   71 */     public static final long class_addIvar = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_addIvar");
/*   72 */     public static final long class_addProtocol = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_addProtocol");
/*   73 */     public static final long class_addProperty = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_addProperty");
/*   74 */     public static final long class_replaceProperty = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_replaceProperty");
/*   75 */     public static final long class_setIvarLayout = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_setIvarLayout");
/*   76 */     public static final long class_setWeakIvarLayout = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_setWeakIvarLayout");
/*   77 */     public static final long class_createInstance = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_createInstance");
/*   78 */     public static final long objc_constructInstance = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_constructInstance");
/*   79 */     public static final long objc_destructInstance = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_destructInstance");
/*   80 */     public static final long objc_allocateClassPair = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_allocateClassPair");
/*   81 */     public static final long objc_registerClassPair = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_registerClassPair");
/*   82 */     public static final long objc_disposeClassPair = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_disposeClassPair");
/*   83 */     public static final long method_getName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_getName");
/*   84 */     public static final long method_getImplementation = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_getImplementation");
/*   85 */     public static final long method_getTypeEncoding = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_getTypeEncoding");
/*   86 */     public static final long method_getNumberOfArguments = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_getNumberOfArguments");
/*   87 */     public static final long method_copyReturnType = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_copyReturnType");
/*   88 */     public static final long method_copyArgumentType = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_copyArgumentType");
/*   89 */     public static final long method_getReturnType = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_getReturnType");
/*   90 */     public static final long method_getArgumentType = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_getArgumentType");
/*   91 */     public static final long method_setImplementation = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_setImplementation");
/*   92 */     public static final long method_exchangeImplementations = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "method_exchangeImplementations");
/*   93 */     public static final long ivar_getName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "ivar_getName");
/*   94 */     public static final long ivar_getTypeEncoding = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "ivar_getTypeEncoding");
/*   95 */     public static final long ivar_getOffset = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "ivar_getOffset");
/*   96 */     public static final long property_getName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "property_getName");
/*   97 */     public static final long property_getAttributes = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "property_getAttributes");
/*   98 */     public static final long property_copyAttributeList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "property_copyAttributeList");
/*   99 */     public static final long property_copyAttributeValue = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "property_copyAttributeValue");
/*  100 */     public static final long objc_getProtocol = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_getProtocol");
/*  101 */     public static final long objc_copyProtocolList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_copyProtocolList");
/*  102 */     public static final long protocol_conformsToProtocol = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_conformsToProtocol");
/*  103 */     public static final long protocol_isEqual = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_isEqual");
/*  104 */     public static final long protocol_getName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_getName");
/*  105 */     public static final long protocol_getMethodDescription = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_getMethodDescription");
/*  106 */     public static final long protocol_copyMethodDescriptionList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_copyMethodDescriptionList");
/*  107 */     public static final long protocol_getProperty = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_getProperty");
/*  108 */     public static final long protocol_copyPropertyList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_copyPropertyList");
/*  109 */     public static final long protocol_copyProtocolList = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_copyProtocolList");
/*  110 */     public static final long objc_allocateProtocol = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_allocateProtocol");
/*  111 */     public static final long objc_registerProtocol = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_registerProtocol");
/*  112 */     public static final long protocol_addMethodDescription = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_addMethodDescription");
/*  113 */     public static final long protocol_addProtocol = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_addProtocol");
/*  114 */     public static final long protocol_addProperty = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "protocol_addProperty");
/*  115 */     public static final long objc_copyImageNames = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_copyImageNames");
/*  116 */     public static final long class_getImageName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "class_getImageName");
/*  117 */     public static final long objc_copyClassNamesForImage = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_copyClassNamesForImage");
/*  118 */     public static final long sel_getName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "sel_getName");
/*  119 */     public static final long sel_getUid = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "sel_getUid");
/*  120 */     public static final long sel_registerName = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "sel_registerName");
/*  121 */     public static final long sel_isEqual = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "sel_isEqual");
/*  122 */     public static final long objc_enumerationMutation = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_enumerationMutation");
/*  123 */     public static final long objc_setEnumerationMutationHandler = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_setEnumerationMutationHandler");
/*  124 */     public static final long imp_implementationWithBlock = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "imp_implementationWithBlock");
/*  125 */     public static final long imp_getBlock = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "imp_getBlock");
/*  126 */     public static final long imp_removeBlock = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "imp_removeBlock");
/*  127 */     public static final long objc_loadWeak = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_loadWeak");
/*  128 */     public static final long objc_storeWeak = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_storeWeak");
/*  129 */     public static final long objc_setAssociatedObject = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_setAssociatedObject");
/*  130 */     public static final long objc_getAssociatedObject = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_getAssociatedObject");
/*  131 */     public static final long objc_removeAssociatedObjects = APIUtil.apiGetFunctionAddress((FunctionProvider)ObjCRuntime.OBJC, "objc_removeAssociatedObjects"); }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static SharedLibrary getLibrary() {
/*  137 */     return OBJC;
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
/*      */   protected ObjCRuntime() {
/*  186 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("id")
/*      */   public static long object_copy(@NativeType("id") long obj, @NativeType("size_t") long size) {
/*  194 */     long __functionAddress = Functions.object_copy;
/*  195 */     if (Checks.CHECKS) {
/*  196 */       Checks.check(obj);
/*      */     }
/*  198 */     return JNI.invokePPP(obj, size, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("id")
/*      */   public static long object_dispose(@NativeType("id") long obj) {
/*  206 */     long __functionAddress = Functions.object_dispose;
/*  207 */     if (Checks.CHECKS) {
/*  208 */       Checks.check(obj);
/*      */     }
/*  210 */     return JNI.invokePP(obj, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long object_getClass(@NativeType("id") long obj) {
/*  218 */     long __functionAddress = Functions.object_getClass;
/*  219 */     return JNI.invokePP(obj, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long object_setClass(@NativeType("id") long obj, @NativeType("Class") long cls) {
/*  227 */     long __functionAddress = Functions.object_setClass;
/*  228 */     if (Checks.CHECKS) {
/*  229 */       Checks.check(cls);
/*      */     }
/*  231 */     return JNI.invokePPP(obj, cls, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobject_getClassName(long obj) {
/*  238 */     long __functionAddress = Functions.object_getClassName;
/*  239 */     return JNI.invokePP(obj, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("char const *")
/*      */   public static String object_getClassName(@NativeType("id") long obj) {
/*  245 */     long __result = nobject_getClassName(obj);
/*  246 */     return MemoryUtil.memUTF8Safe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static long object_getIndexedIvars(@NativeType("id") long obj) {
/*  254 */     long __functionAddress = Functions.object_getIndexedIvars;
/*  255 */     if (Checks.CHECKS) {
/*  256 */       Checks.check(obj);
/*      */     }
/*  258 */     return JNI.invokePP(obj, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("id")
/*      */   public static long object_getIvar(@NativeType("id") long obj, @NativeType("Ivar") long ivar) {
/*  266 */     long __functionAddress = Functions.object_getIvar;
/*  267 */     if (Checks.CHECKS) {
/*  268 */       Checks.check(ivar);
/*      */     }
/*  270 */     return JNI.invokePPP(obj, ivar, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void object_setIvar(@NativeType("id") long obj, @NativeType("Ivar") long ivar, @NativeType("id") long value) {
/*  277 */     long __functionAddress = Functions.object_setIvar;
/*  278 */     if (Checks.CHECKS) {
/*  279 */       Checks.check(obj);
/*  280 */       Checks.check(ivar);
/*  281 */       Checks.check(value);
/*      */     } 
/*  283 */     JNI.invokePPPV(obj, ivar, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobject_setInstanceVariable(long obj, long name, long value) {
/*  290 */     long __functionAddress = Functions.object_setInstanceVariable;
/*  291 */     if (Checks.CHECKS) {
/*  292 */       Checks.check(obj);
/*      */     }
/*  294 */     return JNI.invokePPPP(obj, name, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Ivar")
/*      */   public static long object_setInstanceVariable(@NativeType("id") long obj, @NativeType("char const *") ByteBuffer name, @NativeType("void *") ByteBuffer value) {
/*  300 */     if (Checks.CHECKS) {
/*  301 */       Checks.checkNT1(name);
/*      */     }
/*  303 */     return nobject_setInstanceVariable(obj, MemoryUtil.memAddress(name), MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Ivar")
/*      */   public static long object_setInstanceVariable(@NativeType("id") long obj, @NativeType("char const *") CharSequence name, @NativeType("void *") ByteBuffer value) {
/*  309 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  311 */       stack.nUTF8(name, true);
/*  312 */       long nameEncoded = stack.getPointerAddress();
/*  313 */       return nobject_setInstanceVariable(obj, nameEncoded, MemoryUtil.memAddress(value));
/*      */     } finally {
/*  315 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobject_getInstanceVariable(long obj, long name, long outValue) {
/*  323 */     long __functionAddress = Functions.object_getInstanceVariable;
/*  324 */     if (Checks.CHECKS) {
/*  325 */       Checks.check(obj);
/*      */     }
/*  327 */     return JNI.invokePPPP(obj, name, outValue, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Ivar")
/*      */   public static long object_getInstanceVariable(@NativeType("id") long obj, @NativeType("char const *") ByteBuffer name, @NativeType("void **") PointerBuffer outValue) {
/*  333 */     if (Checks.CHECKS) {
/*  334 */       Checks.checkNT1(name);
/*  335 */       Checks.check((CustomBuffer)outValue, 1);
/*      */     } 
/*  337 */     return nobject_getInstanceVariable(obj, MemoryUtil.memAddress(name), MemoryUtil.memAddress((CustomBuffer)outValue));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Ivar")
/*      */   public static long object_getInstanceVariable(@NativeType("id") long obj, @NativeType("char const *") CharSequence name, @NativeType("void **") PointerBuffer outValue) {
/*  343 */     if (Checks.CHECKS) {
/*  344 */       Checks.check((CustomBuffer)outValue, 1);
/*      */     }
/*  346 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  348 */       stack.nUTF8(name, true);
/*  349 */       long nameEncoded = stack.getPointerAddress();
/*  350 */       return nobject_getInstanceVariable(obj, nameEncoded, MemoryUtil.memAddress((CustomBuffer)outValue));
/*      */     } finally {
/*  352 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_getClass(long name) {
/*  360 */     long __functionAddress = Functions.objc_getClass;
/*  361 */     return JNI.invokePP(name, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_getClass(@NativeType("char const *") ByteBuffer name) {
/*  367 */     if (Checks.CHECKS) {
/*  368 */       Checks.checkNT1(name);
/*      */     }
/*  370 */     return nobjc_getClass(MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_getClass(@NativeType("char const *") CharSequence name) {
/*  376 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  378 */       stack.nUTF8(name, true);
/*  379 */       long nameEncoded = stack.getPointerAddress();
/*  380 */       return nobjc_getClass(nameEncoded);
/*      */     } finally {
/*  382 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_getMetaClass(long name) {
/*  390 */     long __functionAddress = Functions.objc_getMetaClass;
/*  391 */     return JNI.invokePP(name, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_getMetaClass(@NativeType("char const *") ByteBuffer name) {
/*  397 */     if (Checks.CHECKS) {
/*  398 */       Checks.checkNT1(name);
/*      */     }
/*  400 */     return nobjc_getMetaClass(MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_getMetaClass(@NativeType("char const *") CharSequence name) {
/*  406 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  408 */       stack.nUTF8(name, true);
/*  409 */       long nameEncoded = stack.getPointerAddress();
/*  410 */       return nobjc_getMetaClass(nameEncoded);
/*      */     } finally {
/*  412 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_lookUpClass(long name) {
/*  420 */     long __functionAddress = Functions.objc_lookUpClass;
/*  421 */     return JNI.invokePP(name, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_lookUpClass(@NativeType("char const *") ByteBuffer name) {
/*  427 */     if (Checks.CHECKS) {
/*  428 */       Checks.checkNT1(name);
/*      */     }
/*  430 */     return nobjc_lookUpClass(MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_lookUpClass(@NativeType("char const *") CharSequence name) {
/*  436 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  438 */       stack.nUTF8(name, true);
/*  439 */       long nameEncoded = stack.getPointerAddress();
/*  440 */       return nobjc_lookUpClass(nameEncoded);
/*      */     } finally {
/*  442 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_getRequiredClass(long name) {
/*  450 */     long __functionAddress = Functions.objc_getRequiredClass;
/*  451 */     return JNI.invokePP(name, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_getRequiredClass(@NativeType("char const *") ByteBuffer name) {
/*  457 */     if (Checks.CHECKS) {
/*  458 */       Checks.checkNT1(name);
/*      */     }
/*  460 */     return nobjc_getRequiredClass(MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_getRequiredClass(@NativeType("char const *") CharSequence name) {
/*  466 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  468 */       stack.nUTF8(name, true);
/*  469 */       long nameEncoded = stack.getPointerAddress();
/*  470 */       return nobjc_getRequiredClass(nameEncoded);
/*      */     } finally {
/*  472 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nobjc_getClassList(long buffer, int bufferCount) {
/*  480 */     long __functionAddress = Functions.objc_getClassList;
/*  481 */     return JNI.invokePI(buffer, bufferCount, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int objc_getClassList(@NativeType("Class *") PointerBuffer buffer) {
/*  486 */     return nobjc_getClassList(MemoryUtil.memAddressSafe((Pointer)buffer), Checks.remainingSafe((CustomBuffer)buffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_copyClassList(long outCount) {
/*  493 */     long __functionAddress = Functions.objc_copyClassList;
/*  494 */     return JNI.invokePP(outCount, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Class *")
/*      */   public static PointerBuffer objc_copyClassList() {
/*  500 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*  501 */     IntBuffer outCount = stack.callocInt(1);
/*      */     try {
/*  503 */       long __result = nobjc_copyClassList(MemoryUtil.memAddress(outCount));
/*  504 */       return MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
/*      */     } finally {
/*  506 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_getName(long cls) {
/*  514 */     long __functionAddress = Functions.class_getName;
/*  515 */     return JNI.invokePP(cls, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("char const *")
/*      */   public static String class_getName(@NativeType("Class") long cls) {
/*  521 */     long __result = nclass_getName(cls);
/*  522 */     return MemoryUtil.memUTF8Safe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_isMetaClass(@NativeType("Class") long cls) {
/*  530 */     long __functionAddress = Functions.class_isMetaClass;
/*  531 */     return JNI.invokePZ(cls, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long class_getSuperclass(@NativeType("Class") long cls) {
/*  539 */     long __functionAddress = Functions.class_getSuperclass;
/*  540 */     return JNI.invokePP(cls, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int class_getVersion(@NativeType("Class") long cls) {
/*  547 */     long __functionAddress = Functions.class_getVersion;
/*  548 */     if (Checks.CHECKS) {
/*  549 */       Checks.check(cls);
/*      */     }
/*  551 */     return JNI.invokePI(cls, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void class_setVersion(@NativeType("Class") long cls, int version) {
/*  558 */     long __functionAddress = Functions.class_setVersion;
/*  559 */     if (Checks.CHECKS) {
/*  560 */       Checks.check(cls);
/*      */     }
/*  562 */     JNI.invokePV(cls, version, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("size_t")
/*      */   public static long class_getInstanceSize(@NativeType("Class") long cls) {
/*  570 */     long __functionAddress = Functions.class_getInstanceSize;
/*  571 */     return JNI.invokePP(cls, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_getInstanceVariable(long cls, long name) {
/*  578 */     long __functionAddress = Functions.class_getInstanceVariable;
/*  579 */     if (Checks.CHECKS) {
/*  580 */       Checks.check(cls);
/*      */     }
/*  582 */     return JNI.invokePPP(cls, name, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Ivar")
/*      */   public static long class_getInstanceVariable(@NativeType("Class") long cls, @NativeType("char const *") ByteBuffer name) {
/*  588 */     if (Checks.CHECKS) {
/*  589 */       Checks.checkNT1(name);
/*      */     }
/*  591 */     return nclass_getInstanceVariable(cls, MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Ivar")
/*      */   public static long class_getInstanceVariable(@NativeType("Class") long cls, @NativeType("char const *") CharSequence name) {
/*  597 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  599 */       stack.nUTF8(name, true);
/*  600 */       long nameEncoded = stack.getPointerAddress();
/*  601 */       return nclass_getInstanceVariable(cls, nameEncoded);
/*      */     } finally {
/*  603 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_getClassVariable(long cls, long name) {
/*  611 */     long __functionAddress = Functions.class_getClassVariable;
/*  612 */     if (Checks.CHECKS) {
/*  613 */       Checks.check(cls);
/*      */     }
/*  615 */     return JNI.invokePPP(cls, name, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Ivar")
/*      */   public static long class_getClassVariable(@NativeType("Class") long cls, @NativeType("char const *") ByteBuffer name) {
/*  621 */     if (Checks.CHECKS) {
/*  622 */       Checks.checkNT1(name);
/*      */     }
/*  624 */     return nclass_getClassVariable(cls, MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Ivar")
/*      */   public static long class_getClassVariable(@NativeType("Class") long cls, @NativeType("char const *") CharSequence name) {
/*  630 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  632 */       stack.nUTF8(name, true);
/*  633 */       long nameEncoded = stack.getPointerAddress();
/*  634 */       return nclass_getClassVariable(cls, nameEncoded);
/*      */     } finally {
/*  636 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_copyIvarList(long cls, long outCount) {
/*  644 */     long __functionAddress = Functions.class_copyIvarList;
/*  645 */     return JNI.invokePPP(cls, outCount, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Ivar *")
/*      */   public static PointerBuffer class_copyIvarList(@NativeType("Class") long cls) {
/*  651 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*  652 */     IntBuffer outCount = stack.callocInt(1);
/*      */     try {
/*  654 */       long __result = nclass_copyIvarList(cls, MemoryUtil.memAddress(outCount));
/*  655 */       return MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
/*      */     } finally {
/*  657 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("Method")
/*      */   public static long class_getInstanceMethod(@NativeType("Class") long cls, @NativeType("SEL") long name) {
/*  666 */     long __functionAddress = Functions.class_getInstanceMethod;
/*  667 */     if (Checks.CHECKS) {
/*  668 */       Checks.check(cls);
/*  669 */       Checks.check(name);
/*      */     } 
/*  671 */     return JNI.invokePPP(cls, name, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("Method")
/*      */   public static long class_getClassMethod(@NativeType("Class") long cls, @NativeType("SEL") long name) {
/*  679 */     long __functionAddress = Functions.class_getClassMethod;
/*  680 */     if (Checks.CHECKS) {
/*  681 */       Checks.check(cls);
/*  682 */       Checks.check(name);
/*      */     } 
/*  684 */     return JNI.invokePPP(cls, name, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("IMP")
/*      */   public static long class_getMethodImplementation(@NativeType("Class") long cls, @NativeType("SEL") long name) {
/*  692 */     long __functionAddress = Functions.class_getMethodImplementation;
/*  693 */     if (Checks.CHECKS) {
/*  694 */       Checks.check(name);
/*      */     }
/*  696 */     return JNI.invokePPP(cls, name, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_respondsToSelector(@NativeType("Class") long cls, @NativeType("SEL") long name) {
/*  704 */     long __functionAddress = Functions.class_respondsToSelector;
/*  705 */     if (Checks.CHECKS) {
/*  706 */       Checks.check(cls);
/*  707 */       Checks.check(name);
/*      */     } 
/*  709 */     return JNI.invokePPZ(cls, name, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_copyMethodList(long cls, long outCount) {
/*  716 */     long __functionAddress = Functions.class_copyMethodList;
/*  717 */     return JNI.invokePPP(cls, outCount, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Method *")
/*      */   public static PointerBuffer class_copyMethodList(@NativeType("Class") long cls) {
/*  723 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*  724 */     IntBuffer outCount = stack.callocInt(1);
/*      */     try {
/*  726 */       long __result = nclass_copyMethodList(cls, MemoryUtil.memAddress(outCount));
/*  727 */       return MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
/*      */     } finally {
/*  729 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_conformsToProtocol(@NativeType("Class") long cls, @NativeType("Protocol *") long protocol) {
/*  738 */     long __functionAddress = Functions.class_conformsToProtocol;
/*  739 */     if (Checks.CHECKS) {
/*  740 */       Checks.check(cls);
/*  741 */       Checks.check(protocol);
/*      */     } 
/*  743 */     return JNI.invokePPZ(cls, protocol, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_copyProtocolList(long cls, long outCount) {
/*  750 */     long __functionAddress = Functions.class_copyProtocolList;
/*  751 */     return JNI.invokePPP(cls, outCount, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Protocol **")
/*      */   public static PointerBuffer class_copyProtocolList(@NativeType("Class") long cls) {
/*  757 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*  758 */     IntBuffer outCount = stack.callocInt(1);
/*      */     try {
/*  760 */       long __result = nclass_copyProtocolList(cls, MemoryUtil.memAddress(outCount));
/*  761 */       return MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
/*      */     } finally {
/*  763 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_getProperty(long cls, long name) {
/*  771 */     long __functionAddress = Functions.class_getProperty;
/*  772 */     return JNI.invokePPP(cls, name, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("objc_property_t")
/*      */   public static long class_getProperty(@NativeType("Class") long cls, @NativeType("char const *") ByteBuffer name) {
/*  778 */     if (Checks.CHECKS) {
/*  779 */       Checks.checkNT1(name);
/*      */     }
/*  781 */     return nclass_getProperty(cls, MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("objc_property_t")
/*      */   public static long class_getProperty(@NativeType("Class") long cls, @NativeType("char const *") CharSequence name) {
/*  787 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  789 */       stack.nUTF8(name, true);
/*  790 */       long nameEncoded = stack.getPointerAddress();
/*  791 */       return nclass_getProperty(cls, nameEncoded);
/*      */     } finally {
/*  793 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_copyPropertyList(long cls, long outCount) {
/*  801 */     long __functionAddress = Functions.class_copyPropertyList;
/*  802 */     return JNI.invokePPP(cls, outCount, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("objc_property_t *")
/*      */   public static PointerBuffer class_copyPropertyList(@NativeType("Class") long cls) {
/*  808 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*  809 */     IntBuffer outCount = stack.callocInt(1);
/*      */     try {
/*  811 */       long __result = nclass_copyPropertyList(cls, MemoryUtil.memAddress(outCount));
/*  812 */       return MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
/*      */     } finally {
/*  814 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_getIvarLayout(long cls) {
/*  822 */     long __functionAddress = Functions.class_getIvarLayout;
/*  823 */     if (Checks.CHECKS) {
/*  824 */       Checks.check(cls);
/*      */     }
/*  826 */     return JNI.invokePP(cls, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("uint8_t const *")
/*      */   public static String class_getIvarLayout(@NativeType("Class") long cls) {
/*  832 */     long __result = nclass_getIvarLayout(cls);
/*  833 */     return MemoryUtil.memASCIISafe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_getWeakIvarLayout(long cls) {
/*  840 */     long __functionAddress = Functions.class_getWeakIvarLayout;
/*  841 */     if (Checks.CHECKS) {
/*  842 */       Checks.check(cls);
/*      */     }
/*  844 */     return JNI.invokePP(cls, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("uint8_t const *")
/*      */   public static String class_getWeakIvarLayout(@NativeType("Class") long cls) {
/*  850 */     long __result = nclass_getWeakIvarLayout(cls);
/*  851 */     return MemoryUtil.memASCIISafe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean nclass_addMethod(long cls, long name, long imp, long types) {
/*  858 */     long __functionAddress = Functions.class_addMethod;
/*  859 */     if (Checks.CHECKS) {
/*  860 */       Checks.check(cls);
/*  861 */       Checks.check(name);
/*  862 */       Checks.check(imp);
/*      */     } 
/*  864 */     return JNI.invokePPPPZ(cls, name, imp, types, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_addMethod(@NativeType("Class") long cls, @NativeType("SEL") long name, @NativeType("IMP") long imp, @NativeType("char const *") ByteBuffer types) {
/*  870 */     if (Checks.CHECKS) {
/*  871 */       Checks.checkNT1(types);
/*      */     }
/*  873 */     return nclass_addMethod(cls, name, imp, MemoryUtil.memAddress(types));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_addMethod(@NativeType("Class") long cls, @NativeType("SEL") long name, @NativeType("IMP") long imp, @NativeType("char const *") CharSequence types) {
/*  879 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  881 */       stack.nUTF8(types, true);
/*  882 */       long typesEncoded = stack.getPointerAddress();
/*  883 */       return nclass_addMethod(cls, name, imp, typesEncoded);
/*      */     } finally {
/*  885 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_replaceMethod(long cls, long name, long imp, long types) {
/*  893 */     long __functionAddress = Functions.class_replaceMethod;
/*  894 */     if (Checks.CHECKS) {
/*  895 */       Checks.check(cls);
/*  896 */       Checks.check(name);
/*  897 */       Checks.check(imp);
/*      */     } 
/*  899 */     return JNI.invokePPPPP(cls, name, imp, types, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("IMP")
/*      */   public static long class_replaceMethod(@NativeType("Class") long cls, @NativeType("SEL") long name, @NativeType("IMP") long imp, @NativeType("char const *") ByteBuffer types) {
/*  905 */     if (Checks.CHECKS) {
/*  906 */       Checks.checkNT1(types);
/*      */     }
/*  908 */     return nclass_replaceMethod(cls, name, imp, MemoryUtil.memAddress(types));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("IMP")
/*      */   public static long class_replaceMethod(@NativeType("Class") long cls, @NativeType("SEL") long name, @NativeType("IMP") long imp, @NativeType("char const *") CharSequence types) {
/*  914 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  916 */       stack.nUTF8(types, true);
/*  917 */       long typesEncoded = stack.getPointerAddress();
/*  918 */       return nclass_replaceMethod(cls, name, imp, typesEncoded);
/*      */     } finally {
/*  920 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean nclass_addIvar(long cls, long name, long size, byte alignment, long types) {
/*  928 */     long __functionAddress = Functions.class_addIvar;
/*  929 */     if (Checks.CHECKS) {
/*  930 */       Checks.check(cls);
/*      */     }
/*  932 */     return JNI.invokePPPUPZ(cls, name, size, alignment, types, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_addIvar(@NativeType("Class") long cls, @NativeType("char const *") ByteBuffer name, @NativeType("size_t") long size, @NativeType("uint8_t") byte alignment, @NativeType("char const *") ByteBuffer types) {
/*  938 */     if (Checks.CHECKS) {
/*  939 */       Checks.checkNT1(name);
/*  940 */       Checks.checkNT1(types);
/*      */     } 
/*  942 */     return nclass_addIvar(cls, MemoryUtil.memAddress(name), size, alignment, MemoryUtil.memAddress(types));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_addIvar(@NativeType("Class") long cls, @NativeType("char const *") CharSequence name, @NativeType("size_t") long size, @NativeType("uint8_t") byte alignment, @NativeType("char const *") CharSequence types) {
/*  948 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  950 */       stack.nUTF8(name, true);
/*  951 */       long nameEncoded = stack.getPointerAddress();
/*  952 */       stack.nUTF8(types, true);
/*  953 */       long typesEncoded = stack.getPointerAddress();
/*  954 */       return nclass_addIvar(cls, nameEncoded, size, alignment, typesEncoded);
/*      */     } finally {
/*  956 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_addProtocol(@NativeType("Class") long cls, @NativeType("Protocol *") long protocol) {
/*  965 */     long __functionAddress = Functions.class_addProtocol;
/*  966 */     if (Checks.CHECKS) {
/*  967 */       Checks.check(cls);
/*  968 */       Checks.check(protocol);
/*      */     } 
/*  970 */     return JNI.invokePPZ(cls, protocol, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean nclass_addProperty(long cls, long name, long attributes, int attributeCount) {
/*  977 */     long __functionAddress = Functions.class_addProperty;
/*  978 */     if (Checks.CHECKS) {
/*  979 */       Checks.check(cls);
/*  980 */       Struct.validate(attributes, attributeCount, ObjCPropertyAttribute.SIZEOF, ObjCPropertyAttribute::validate);
/*      */     } 
/*  982 */     return JNI.invokePPPZ(cls, name, attributes, attributeCount, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_addProperty(@NativeType("Class") long cls, @NativeType("char const *") ByteBuffer name, @NativeType("objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer attributes) {
/*  988 */     if (Checks.CHECKS) {
/*  989 */       Checks.checkNT1(name);
/*      */     }
/*  991 */     return nclass_addProperty(cls, MemoryUtil.memAddress(name), attributes.address(), attributes.remaining());
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean class_addProperty(@NativeType("Class") long cls, @NativeType("char const *") CharSequence name, @NativeType("objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer attributes) {
/*  997 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  999 */       stack.nUTF8(name, true);
/* 1000 */       long nameEncoded = stack.getPointerAddress();
/* 1001 */       return nclass_addProperty(cls, nameEncoded, attributes.address(), attributes.remaining());
/*      */     } finally {
/* 1003 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nclass_replaceProperty(long cls, long name, long attributes, int attributeCount) {
/* 1011 */     long __functionAddress = Functions.class_replaceProperty;
/* 1012 */     if (Checks.CHECKS) {
/* 1013 */       Checks.check(cls);
/* 1014 */       Struct.validate(attributes, attributeCount, ObjCPropertyAttribute.SIZEOF, ObjCPropertyAttribute::validate);
/*      */     } 
/* 1016 */     JNI.invokePPPV(cls, name, attributes, attributeCount, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void class_replaceProperty(@NativeType("Class") long cls, @NativeType("char const *") ByteBuffer name, @NativeType("objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer attributes) {
/* 1021 */     if (Checks.CHECKS) {
/* 1022 */       Checks.checkNT1(name);
/*      */     }
/* 1024 */     nclass_replaceProperty(cls, MemoryUtil.memAddress(name), attributes.address(), attributes.remaining());
/*      */   }
/*      */ 
/*      */   
/*      */   public static void class_replaceProperty(@NativeType("Class") long cls, @NativeType("char const *") CharSequence name, @NativeType("objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer attributes) {
/* 1029 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1031 */       stack.nUTF8(name, true);
/* 1032 */       long nameEncoded = stack.getPointerAddress();
/* 1033 */       nclass_replaceProperty(cls, nameEncoded, attributes.address(), attributes.remaining());
/*      */     } finally {
/* 1035 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nclass_setIvarLayout(long cls, long layout) {
/* 1043 */     long __functionAddress = Functions.class_setIvarLayout;
/* 1044 */     if (Checks.CHECKS) {
/* 1045 */       Checks.check(cls);
/*      */     }
/* 1047 */     JNI.invokePPV(cls, layout, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void class_setIvarLayout(@NativeType("Class") long cls, @NativeType("uint8_t const *") ByteBuffer layout) {
/* 1052 */     if (Checks.CHECKS) {
/* 1053 */       Checks.checkNT1(layout);
/*      */     }
/* 1055 */     nclass_setIvarLayout(cls, MemoryUtil.memAddress(layout));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void class_setIvarLayout(@NativeType("Class") long cls, @NativeType("uint8_t const *") CharSequence layout) {
/* 1060 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1062 */       stack.nASCII(layout, true);
/* 1063 */       long layoutEncoded = stack.getPointerAddress();
/* 1064 */       nclass_setIvarLayout(cls, layoutEncoded);
/*      */     } finally {
/* 1066 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nclass_setWeakIvarLayout(long cls, long layout) {
/* 1074 */     long __functionAddress = Functions.class_setWeakIvarLayout;
/* 1075 */     if (Checks.CHECKS) {
/* 1076 */       Checks.check(cls);
/*      */     }
/* 1078 */     JNI.invokePPV(cls, layout, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void class_setWeakIvarLayout(@NativeType("Class") long cls, @NativeType("uint8_t const *") ByteBuffer layout) {
/* 1083 */     if (Checks.CHECKS) {
/* 1084 */       Checks.checkNT1(layout);
/*      */     }
/* 1086 */     nclass_setWeakIvarLayout(cls, MemoryUtil.memAddress(layout));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void class_setWeakIvarLayout(@NativeType("Class") long cls, @NativeType("uint8_t const *") CharSequence layout) {
/* 1091 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1093 */       stack.nASCII(layout, true);
/* 1094 */       long layoutEncoded = stack.getPointerAddress();
/* 1095 */       nclass_setWeakIvarLayout(cls, layoutEncoded);
/*      */     } finally {
/* 1097 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("id")
/*      */   public static long class_createInstance(@NativeType("Class") long cls, @NativeType("size_t") long extraBytes) {
/* 1106 */     long __functionAddress = Functions.class_createInstance;
/* 1107 */     if (Checks.CHECKS) {
/* 1108 */       Checks.check(cls);
/*      */     }
/* 1110 */     return JNI.invokePPP(cls, extraBytes, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_constructInstance(long cls, long bytes) {
/* 1117 */     long __functionAddress = Functions.objc_constructInstance;
/* 1118 */     return JNI.invokePPP(cls, bytes, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("id")
/*      */   public static long objc_constructInstance(@NativeType("Class") long cls, @NativeType("void *") ByteBuffer bytes) {
/* 1124 */     if (Checks.CHECKS && 
/* 1125 */       Checks.DEBUG) {
/* 1126 */       Checks.checkSafe(bytes, class_getInstanceSize(cls));
/*      */     }
/*      */     
/* 1129 */     return nobjc_constructInstance(cls, MemoryUtil.memAddressSafe(bytes));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static long objc_destructInstance(@NativeType("id") long obj) {
/* 1137 */     long __functionAddress = Functions.objc_destructInstance;
/* 1138 */     if (Checks.CHECKS) {
/* 1139 */       Checks.check(obj);
/*      */     }
/* 1141 */     return JNI.invokePP(obj, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_allocateClassPair(long superclass, long name, long extraBytes) {
/* 1148 */     long __functionAddress = Functions.objc_allocateClassPair;
/* 1149 */     return JNI.invokePPPP(superclass, name, extraBytes, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_allocateClassPair(@NativeType("Class") long superclass, @NativeType("char const *") ByteBuffer name, @NativeType("size_t") long extraBytes) {
/* 1155 */     if (Checks.CHECKS) {
/* 1156 */       Checks.checkNT1(name);
/*      */     }
/* 1158 */     return nobjc_allocateClassPair(superclass, MemoryUtil.memAddress(name), extraBytes);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Class")
/*      */   public static long objc_allocateClassPair(@NativeType("Class") long superclass, @NativeType("char const *") CharSequence name, @NativeType("size_t") long extraBytes) {
/* 1164 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1166 */       stack.nUTF8(name, true);
/* 1167 */       long nameEncoded = stack.getPointerAddress();
/* 1168 */       return nobjc_allocateClassPair(superclass, nameEncoded, extraBytes);
/*      */     } finally {
/* 1170 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void objc_registerClassPair(@NativeType("Class") long cls) {
/* 1178 */     long __functionAddress = Functions.objc_registerClassPair;
/* 1179 */     if (Checks.CHECKS) {
/* 1180 */       Checks.check(cls);
/*      */     }
/* 1182 */     JNI.invokePV(cls, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void objc_disposeClassPair(@NativeType("Class") long cls) {
/* 1189 */     long __functionAddress = Functions.objc_disposeClassPair;
/* 1190 */     if (Checks.CHECKS) {
/* 1191 */       Checks.check(cls);
/*      */     }
/* 1193 */     JNI.invokePV(cls, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("SEL")
/*      */   public static long method_getName(@NativeType("Method") long m) {
/* 1201 */     long __functionAddress = Functions.method_getName;
/* 1202 */     if (Checks.CHECKS) {
/* 1203 */       Checks.check(m);
/*      */     }
/* 1205 */     return JNI.invokePP(m, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("IMP")
/*      */   public static long method_getImplementation(@NativeType("Method") long m) {
/* 1213 */     long __functionAddress = Functions.method_getImplementation;
/* 1214 */     if (Checks.CHECKS) {
/* 1215 */       Checks.check(m);
/*      */     }
/* 1217 */     return JNI.invokePP(m, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nmethod_getTypeEncoding(long m) {
/* 1224 */     long __functionAddress = Functions.method_getTypeEncoding;
/* 1225 */     if (Checks.CHECKS) {
/* 1226 */       Checks.check(m);
/*      */     }
/* 1228 */     return JNI.invokePP(m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("char const *")
/*      */   public static String method_getTypeEncoding(@NativeType("Method") long m) {
/* 1234 */     long __result = nmethod_getTypeEncoding(m);
/* 1235 */     return MemoryUtil.memUTF8Safe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("unsigned int")
/*      */   public static int method_getNumberOfArguments(@NativeType("Method") long m) {
/* 1243 */     long __functionAddress = Functions.method_getNumberOfArguments;
/* 1244 */     if (Checks.CHECKS) {
/* 1245 */       Checks.check(m);
/*      */     }
/* 1247 */     return JNI.invokePI(m, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nmethod_copyReturnType(long m) {
/* 1254 */     long __functionAddress = Functions.method_copyReturnType;
/* 1255 */     if (Checks.CHECKS) {
/* 1256 */       Checks.check(m);
/*      */     }
/* 1258 */     return JNI.invokePP(m, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("char *")
/*      */   public static String method_copyReturnType(@NativeType("Method") long m) {
/* 1264 */     long __result = nmethod_copyReturnType(m);
/* 1265 */     return MemoryUtil.memUTF8Safe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nmethod_copyArgumentType(long m, int index) {
/* 1272 */     long __functionAddress = Functions.method_copyArgumentType;
/* 1273 */     if (Checks.CHECKS) {
/* 1274 */       Checks.check(m);
/*      */     }
/* 1276 */     return JNI.invokePP(m, index, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("char *")
/*      */   public static String method_copyArgumentType(@NativeType("Method") long m, @NativeType("unsigned int") int index) {
/* 1282 */     long __result = 0L;
/*      */     try {
/* 1284 */       __result = nmethod_copyArgumentType(m, index);
/* 1285 */       return MemoryUtil.memUTF8Safe(__result);
/*      */     } finally {
/* 1287 */       if (__result != 0L) LibCStdlib.nfree(__result);
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nmethod_getReturnType(long m, long dst, long dst_len) {
/* 1295 */     long __functionAddress = Functions.method_getReturnType;
/* 1296 */     if (Checks.CHECKS) {
/* 1297 */       Checks.check(m);
/*      */     }
/* 1299 */     JNI.invokePPPV(m, dst, dst_len, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void method_getReturnType(@NativeType("Method") long m, @NativeType("char *") ByteBuffer dst) {
/* 1304 */     nmethod_getReturnType(m, MemoryUtil.memAddress(dst), dst.remaining());
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String method_getReturnType(@NativeType("Method") long m, @NativeType("size_t") long dst_len) {
/* 1310 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1312 */       ByteBuffer dst = stack.malloc((int)dst_len);
/* 1313 */       nmethod_getReturnType(m, MemoryUtil.memAddress(dst), dst_len);
/* 1314 */       return MemoryUtil.memUTF8(MemoryUtil.memByteBufferNT1(MemoryUtil.memAddress(dst), (int)dst_len));
/*      */     } finally {
/* 1316 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nmethod_getArgumentType(long m, int index, long dst, long dst_len) {
/* 1324 */     long __functionAddress = Functions.method_getArgumentType;
/* 1325 */     if (Checks.CHECKS) {
/* 1326 */       Checks.check(m);
/*      */     }
/* 1328 */     JNI.invokePPPV(m, index, dst, dst_len, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void method_getArgumentType(@NativeType("Method") long m, @NativeType("unsigned int") int index, @NativeType("char *") ByteBuffer dst) {
/* 1333 */     nmethod_getArgumentType(m, index, MemoryUtil.memAddress(dst), dst.remaining());
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String method_getArgumentType(@NativeType("Method") long m, @NativeType("unsigned int") int index, @NativeType("size_t") long dst_len) {
/* 1339 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1341 */       ByteBuffer dst = stack.malloc((int)dst_len);
/* 1342 */       nmethod_getArgumentType(m, index, MemoryUtil.memAddress(dst), dst_len);
/* 1343 */       return MemoryUtil.memUTF8(MemoryUtil.memByteBufferNT1(MemoryUtil.memAddress(dst), (int)dst_len));
/*      */     } finally {
/* 1345 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("IMP")
/*      */   public static long method_setImplementation(@NativeType("Method") long m, @NativeType("IMP") long imp) {
/* 1354 */     long __functionAddress = Functions.method_setImplementation;
/* 1355 */     if (Checks.CHECKS) {
/* 1356 */       Checks.check(m);
/* 1357 */       Checks.check(imp);
/*      */     } 
/* 1359 */     return JNI.invokePPP(m, imp, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void method_exchangeImplementations(@NativeType("Method") long m1, @NativeType("Method") long m2) {
/* 1366 */     long __functionAddress = Functions.method_exchangeImplementations;
/* 1367 */     if (Checks.CHECKS) {
/* 1368 */       Checks.check(m1);
/* 1369 */       Checks.check(m2);
/*      */     } 
/* 1371 */     JNI.invokePPV(m1, m2, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nivar_getName(long v) {
/* 1378 */     long __functionAddress = Functions.ivar_getName;
/* 1379 */     if (Checks.CHECKS) {
/* 1380 */       Checks.check(v);
/*      */     }
/* 1382 */     return JNI.invokePP(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("char const *")
/*      */   public static String ivar_getName(@NativeType("Ivar") long v) {
/* 1388 */     long __result = nivar_getName(v);
/* 1389 */     return MemoryUtil.memUTF8Safe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nivar_getTypeEncoding(long v) {
/* 1396 */     long __functionAddress = Functions.ivar_getTypeEncoding;
/* 1397 */     if (Checks.CHECKS) {
/* 1398 */       Checks.check(v);
/*      */     }
/* 1400 */     return JNI.invokePP(v, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("char const *")
/*      */   public static String ivar_getTypeEncoding(@NativeType("Ivar") long v) {
/* 1406 */     long __result = nivar_getTypeEncoding(v);
/* 1407 */     return MemoryUtil.memUTF8Safe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ptrdiff_t")
/*      */   public static long ivar_getOffset(@NativeType("Ivar") long v) {
/* 1415 */     long __functionAddress = Functions.ivar_getOffset;
/* 1416 */     if (Checks.CHECKS) {
/* 1417 */       Checks.check(v);
/*      */     }
/* 1419 */     return JNI.invokePP(v, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nproperty_getName(long property) {
/* 1426 */     long __functionAddress = Functions.property_getName;
/* 1427 */     if (Checks.CHECKS) {
/* 1428 */       Checks.check(property);
/*      */     }
/* 1430 */     return JNI.invokePP(property, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("char const *")
/*      */   public static String property_getName(@NativeType("objc_property_t") long property) {
/* 1436 */     long __result = nproperty_getName(property);
/* 1437 */     return MemoryUtil.memUTF8Safe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nproperty_getAttributes(long property) {
/* 1444 */     long __functionAddress = Functions.property_getAttributes;
/* 1445 */     if (Checks.CHECKS) {
/* 1446 */       Checks.check(property);
/*      */     }
/* 1448 */     return JNI.invokePP(property, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("char const *")
/*      */   public static String property_getAttributes(@NativeType("objc_property_t") long property) {
/* 1454 */     long __result = nproperty_getAttributes(property);
/* 1455 */     return MemoryUtil.memUTF8Safe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nproperty_copyAttributeList(long property, long outCount) {
/* 1462 */     long __functionAddress = Functions.property_copyAttributeList;
/* 1463 */     if (Checks.CHECKS) {
/* 1464 */       Checks.check(property);
/*      */     }
/* 1466 */     return JNI.invokePPP(property, outCount, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("objc_property_attribute_t *")
/*      */   public static ObjCPropertyAttribute.Buffer property_copyAttributeList(@NativeType("objc_property_t") long property) {
/* 1472 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/* 1473 */     IntBuffer outCount = stack.callocInt(1);
/*      */     try {
/* 1475 */       long __result = nproperty_copyAttributeList(property, MemoryUtil.memAddress(outCount));
/* 1476 */       return ObjCPropertyAttribute.createSafe(__result, outCount.get(0));
/*      */     } finally {
/* 1478 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nproperty_copyAttributeValue(long property, long attributeName) {
/* 1486 */     long __functionAddress = Functions.property_copyAttributeValue;
/* 1487 */     if (Checks.CHECKS) {
/* 1488 */       Checks.check(property);
/*      */     }
/* 1490 */     return JNI.invokePPP(property, attributeName, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("char *")
/*      */   public static String property_copyAttributeValue(@NativeType("objc_property_t") long property, @NativeType("char const *") ByteBuffer attributeName) {
/* 1496 */     if (Checks.CHECKS) {
/* 1497 */       Checks.checkNT1(attributeName);
/*      */     }
/* 1499 */     long __result = 0L;
/*      */     try {
/* 1501 */       __result = nproperty_copyAttributeValue(property, MemoryUtil.memAddress(attributeName));
/* 1502 */       return MemoryUtil.memUTF8Safe(__result);
/*      */     } finally {
/* 1504 */       if (__result != 0L) LibCStdlib.nfree(__result);
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   @NativeType("char *")
/*      */   public static String property_copyAttributeValue(@NativeType("objc_property_t") long property, @NativeType("char const *") CharSequence attributeName) {
/* 1511 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/* 1512 */     long __result = 0L;
/*      */     try {
/* 1514 */       stack.nUTF8(attributeName, true);
/* 1515 */       long attributeNameEncoded = stack.getPointerAddress();
/* 1516 */       __result = nproperty_copyAttributeValue(property, attributeNameEncoded);
/* 1517 */       return MemoryUtil.memUTF8Safe(__result);
/*      */     } finally {
/* 1519 */       if (__result != 0L) LibCStdlib.nfree(__result); 
/* 1520 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_getProtocol(long name) {
/* 1528 */     long __functionAddress = Functions.objc_getProtocol;
/* 1529 */     return JNI.invokePP(name, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Protocol *")
/*      */   public static long objc_getProtocol(@NativeType("char const *") ByteBuffer name) {
/* 1535 */     if (Checks.CHECKS) {
/* 1536 */       Checks.checkNT1(name);
/*      */     }
/* 1538 */     return nobjc_getProtocol(MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Protocol *")
/*      */   public static long objc_getProtocol(@NativeType("char const *") CharSequence name) {
/* 1544 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1546 */       stack.nUTF8(name, true);
/* 1547 */       long nameEncoded = stack.getPointerAddress();
/* 1548 */       return nobjc_getProtocol(nameEncoded);
/*      */     } finally {
/* 1550 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_copyProtocolList(long outCount) {
/* 1558 */     long __functionAddress = Functions.objc_copyProtocolList;
/* 1559 */     return JNI.invokePP(outCount, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Protocol **")
/*      */   public static PointerBuffer objc_copyProtocolList() {
/* 1565 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/* 1566 */     IntBuffer outCount = stack.callocInt(1);
/*      */     try {
/* 1568 */       long __result = nobjc_copyProtocolList(MemoryUtil.memAddress(outCount));
/* 1569 */       return MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
/*      */     } finally {
/* 1571 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean protocol_conformsToProtocol(@NativeType("Protocol *") long proto, @NativeType("Protocol *") long other) {
/* 1580 */     long __functionAddress = Functions.protocol_conformsToProtocol;
/* 1581 */     if (Checks.CHECKS) {
/* 1582 */       Checks.check(proto);
/* 1583 */       Checks.check(other);
/*      */     } 
/* 1585 */     return JNI.invokePPZ(proto, other, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean protocol_isEqual(@NativeType("Protocol *") long proto, @NativeType("Protocol *") long other) {
/* 1593 */     long __functionAddress = Functions.protocol_isEqual;
/* 1594 */     if (Checks.CHECKS) {
/* 1595 */       Checks.check(proto);
/* 1596 */       Checks.check(other);
/*      */     } 
/* 1598 */     return JNI.invokePPZ(proto, other, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nprotocol_getName(long p) {
/* 1605 */     long __functionAddress = Functions.protocol_getName;
/* 1606 */     if (Checks.CHECKS) {
/* 1607 */       Checks.check(p);
/*      */     }
/* 1609 */     return JNI.invokePP(p, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("char const *")
/*      */   public static String protocol_getName(@NativeType("Protocol *") long p) {
/* 1615 */     long __result = nprotocol_getName(p);
/* 1616 */     return MemoryUtil.memUTF8Safe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nprotocol_getMethodDescription(long p, long aSel, boolean isRequiredMethod, boolean isInstanceMethod, long __result) {
/* 1626 */     long __functionAddress = Functions.protocol_getMethodDescription;
/* 1627 */     if (Checks.CHECKS) {
/* 1628 */       Checks.check(p);
/* 1629 */       Checks.check(aSel);
/*      */     } 
/* 1631 */     nprotocol_getMethodDescription(p, aSel, isRequiredMethod, isInstanceMethod, __functionAddress, __result);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("struct objc_method_description")
/*      */   public static ObjCMethodDescription protocol_getMethodDescription(@NativeType("Protocol *") long p, @NativeType("SEL") long aSel, @NativeType("BOOL") boolean isRequiredMethod, @NativeType("BOOL") boolean isInstanceMethod, @NativeType("struct objc_method_description") ObjCMethodDescription __result) {
/* 1637 */     nprotocol_getMethodDescription(p, aSel, isRequiredMethod, isInstanceMethod, __result.address());
/* 1638 */     return __result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nprotocol_copyMethodDescriptionList(long p, boolean isRequiredMethod, boolean isInstanceMethod, long outCount) {
/* 1645 */     long __functionAddress = Functions.protocol_copyMethodDescriptionList;
/* 1646 */     if (Checks.CHECKS) {
/* 1647 */       Checks.check(p);
/*      */     }
/* 1649 */     return JNI.invokePPP(p, isRequiredMethod, isInstanceMethod, outCount, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("struct objc_method_description *")
/*      */   public static ObjCMethodDescription.Buffer protocol_copyMethodDescriptionList(@NativeType("Protocol *") long p, @NativeType("BOOL") boolean isRequiredMethod, @NativeType("BOOL") boolean isInstanceMethod) {
/* 1655 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/* 1656 */     IntBuffer outCount = stack.callocInt(1);
/*      */     try {
/* 1658 */       long __result = nprotocol_copyMethodDescriptionList(p, isRequiredMethod, isInstanceMethod, MemoryUtil.memAddress(outCount));
/* 1659 */       return ObjCMethodDescription.createSafe(__result, outCount.get(0));
/*      */     } finally {
/* 1661 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nprotocol_getProperty(long proto, long name, boolean isRequiredProperty, boolean isInstanceProperty) {
/* 1669 */     long __functionAddress = Functions.protocol_getProperty;
/* 1670 */     if (Checks.CHECKS) {
/* 1671 */       Checks.check(proto);
/*      */     }
/* 1673 */     return JNI.invokePPP(proto, name, isRequiredProperty, isInstanceProperty, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("objc_property_t")
/*      */   public static long protocol_getProperty(@NativeType("Protocol *") long proto, @NativeType("char const *") ByteBuffer name, @NativeType("BOOL") boolean isRequiredProperty, @NativeType("BOOL") boolean isInstanceProperty) {
/* 1679 */     if (Checks.CHECKS) {
/* 1680 */       Checks.checkNT1(name);
/*      */     }
/* 1682 */     return nprotocol_getProperty(proto, MemoryUtil.memAddress(name), isRequiredProperty, isInstanceProperty);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("objc_property_t")
/*      */   public static long protocol_getProperty(@NativeType("Protocol *") long proto, @NativeType("char const *") CharSequence name, @NativeType("BOOL") boolean isRequiredProperty, @NativeType("BOOL") boolean isInstanceProperty) {
/* 1688 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1690 */       stack.nUTF8(name, true);
/* 1691 */       long nameEncoded = stack.getPointerAddress();
/* 1692 */       return nprotocol_getProperty(proto, nameEncoded, isRequiredProperty, isInstanceProperty);
/*      */     } finally {
/* 1694 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nprotocol_copyPropertyList(long proto, long outCount) {
/* 1702 */     long __functionAddress = Functions.protocol_copyPropertyList;
/* 1703 */     if (Checks.CHECKS) {
/* 1704 */       Checks.check(proto);
/*      */     }
/* 1706 */     return JNI.invokePPP(proto, outCount, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("objc_property_t *")
/*      */   public static PointerBuffer protocol_copyPropertyList(@NativeType("Protocol *") long proto) {
/* 1712 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/* 1713 */     IntBuffer outCount = stack.callocInt(1);
/*      */     try {
/* 1715 */       long __result = nprotocol_copyPropertyList(proto, MemoryUtil.memAddress(outCount));
/* 1716 */       return MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
/*      */     } finally {
/* 1718 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nprotocol_copyProtocolList(long proto, long outCount) {
/* 1726 */     long __functionAddress = Functions.protocol_copyProtocolList;
/* 1727 */     if (Checks.CHECKS) {
/* 1728 */       Checks.check(proto);
/*      */     }
/* 1730 */     return JNI.invokePPP(proto, outCount, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Protocol **")
/*      */   public static PointerBuffer protocol_copyProtocolList(@NativeType("Protocol *") long proto) {
/* 1736 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/* 1737 */     IntBuffer outCount = stack.callocInt(1);
/*      */     try {
/* 1739 */       long __result = nprotocol_copyProtocolList(proto, MemoryUtil.memAddress(outCount));
/* 1740 */       return MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
/*      */     } finally {
/* 1742 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_allocateProtocol(long name) {
/* 1750 */     long __functionAddress = Functions.objc_allocateProtocol;
/* 1751 */     return JNI.invokePP(name, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Protocol *")
/*      */   public static long objc_allocateProtocol(@NativeType("char const *") ByteBuffer name) {
/* 1757 */     if (Checks.CHECKS) {
/* 1758 */       Checks.checkNT1(name);
/*      */     }
/* 1760 */     return nobjc_allocateProtocol(MemoryUtil.memAddress(name));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("Protocol *")
/*      */   public static long objc_allocateProtocol(@NativeType("char const *") CharSequence name) {
/* 1766 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1768 */       stack.nUTF8(name, true);
/* 1769 */       long nameEncoded = stack.getPointerAddress();
/* 1770 */       return nobjc_allocateProtocol(nameEncoded);
/*      */     } finally {
/* 1772 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void objc_registerProtocol(@NativeType("Protocol *") long proto) {
/* 1780 */     long __functionAddress = Functions.objc_registerProtocol;
/* 1781 */     if (Checks.CHECKS) {
/* 1782 */       Checks.check(proto);
/*      */     }
/* 1784 */     JNI.invokePV(proto, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nprotocol_addMethodDescription(long proto, long name, long types, boolean isRequiredMethod, boolean isInstanceMethod) {
/* 1791 */     long __functionAddress = Functions.protocol_addMethodDescription;
/* 1792 */     if (Checks.CHECKS) {
/* 1793 */       Checks.check(proto);
/* 1794 */       Checks.check(name);
/*      */     } 
/* 1796 */     JNI.invokePPPV(proto, name, types, isRequiredMethod, isInstanceMethod, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void protocol_addMethodDescription(@NativeType("Protocol *") long proto, @NativeType("SEL") long name, @NativeType("char const *") ByteBuffer types, @NativeType("BOOL") boolean isRequiredMethod, @NativeType("BOOL") boolean isInstanceMethod) {
/* 1801 */     if (Checks.CHECKS) {
/* 1802 */       Checks.checkNT1(types);
/*      */     }
/* 1804 */     nprotocol_addMethodDescription(proto, name, MemoryUtil.memAddress(types), isRequiredMethod, isInstanceMethod);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void protocol_addMethodDescription(@NativeType("Protocol *") long proto, @NativeType("SEL") long name, @NativeType("char const *") CharSequence types, @NativeType("BOOL") boolean isRequiredMethod, @NativeType("BOOL") boolean isInstanceMethod) {
/* 1809 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1811 */       stack.nUTF8(types, true);
/* 1812 */       long typesEncoded = stack.getPointerAddress();
/* 1813 */       nprotocol_addMethodDescription(proto, name, typesEncoded, isRequiredMethod, isInstanceMethod);
/*      */     } finally {
/* 1815 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void protocol_addProtocol(@NativeType("Protocol *") long proto, @NativeType("Protocol *") long addition) {
/* 1823 */     long __functionAddress = Functions.protocol_addProtocol;
/* 1824 */     if (Checks.CHECKS) {
/* 1825 */       Checks.check(proto);
/* 1826 */       Checks.check(addition);
/*      */     } 
/* 1828 */     JNI.invokePPV(proto, addition, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nprotocol_addProperty(long proto, long name, long attributes, int attributeCount, boolean isRequiredProperty, boolean isInstanceProperty) {
/* 1835 */     long __functionAddress = Functions.protocol_addProperty;
/* 1836 */     if (Checks.CHECKS) {
/* 1837 */       Checks.check(proto);
/* 1838 */       Struct.validate(attributes, attributeCount, ObjCPropertyAttribute.SIZEOF, ObjCPropertyAttribute::validate);
/*      */     } 
/* 1840 */     JNI.invokePPPV(proto, name, attributes, attributeCount, isRequiredProperty, isInstanceProperty, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void protocol_addProperty(@NativeType("Protocol *") long proto, @NativeType("char const *") ByteBuffer name, @NativeType("objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer attributes, @NativeType("BOOL") boolean isRequiredProperty, @NativeType("BOOL") boolean isInstanceProperty) {
/* 1845 */     if (Checks.CHECKS) {
/* 1846 */       Checks.checkNT1(name);
/*      */     }
/* 1848 */     nprotocol_addProperty(proto, MemoryUtil.memAddress(name), attributes.address(), attributes.remaining(), isRequiredProperty, isInstanceProperty);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void protocol_addProperty(@NativeType("Protocol *") long proto, @NativeType("char const *") CharSequence name, @NativeType("objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer attributes, @NativeType("BOOL") boolean isRequiredProperty, @NativeType("BOOL") boolean isInstanceProperty) {
/* 1853 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1855 */       stack.nUTF8(name, true);
/* 1856 */       long nameEncoded = stack.getPointerAddress();
/* 1857 */       nprotocol_addProperty(proto, nameEncoded, attributes.address(), attributes.remaining(), isRequiredProperty, isInstanceProperty);
/*      */     } finally {
/* 1859 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_copyImageNames(long outCount) {
/* 1867 */     long __functionAddress = Functions.objc_copyImageNames;
/* 1868 */     return JNI.invokePP(outCount, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("char const **")
/*      */   public static PointerBuffer objc_copyImageNames() {
/* 1874 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/* 1875 */     IntBuffer outCount = stack.callocInt(1);
/*      */     try {
/* 1877 */       long __result = nobjc_copyImageNames(MemoryUtil.memAddress(outCount));
/* 1878 */       return MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
/*      */     } finally {
/* 1880 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nclass_getImageName(long cls) {
/* 1888 */     long __functionAddress = Functions.class_getImageName;
/* 1889 */     if (Checks.CHECKS) {
/* 1890 */       Checks.check(cls);
/*      */     }
/* 1892 */     return JNI.invokePP(cls, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("char const *")
/*      */   public static String class_getImageName(@NativeType("Class") long cls) {
/* 1898 */     long __result = nclass_getImageName(cls);
/* 1899 */     return MemoryUtil.memUTF8Safe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_copyClassNamesForImage(long image, long outCount) {
/* 1906 */     long __functionAddress = Functions.objc_copyClassNamesForImage;
/* 1907 */     return JNI.invokePPP(image, outCount, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("char const **")
/*      */   public static PointerBuffer objc_copyClassNamesForImage(@NativeType("char const *") ByteBuffer image) {
/* 1913 */     if (Checks.CHECKS) {
/* 1914 */       Checks.checkNT1(image);
/*      */     }
/* 1916 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/* 1917 */     IntBuffer outCount = stack.callocInt(1);
/*      */     try {
/* 1919 */       long __result = nobjc_copyClassNamesForImage(MemoryUtil.memAddress(image), MemoryUtil.memAddress(outCount));
/* 1920 */       return MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
/*      */     } finally {
/* 1922 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("char const **")
/*      */   public static PointerBuffer objc_copyClassNamesForImage(@NativeType("char const *") CharSequence image) {
/* 1929 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1931 */       IntBuffer outCount = stack.callocInt(1);
/* 1932 */       stack.nUTF8(image, true);
/* 1933 */       long imageEncoded = stack.getPointerAddress();
/* 1934 */       long __result = nobjc_copyClassNamesForImage(imageEncoded, MemoryUtil.memAddress(outCount));
/* 1935 */       return MemoryUtil.memPointerBufferSafe(__result, outCount.get(0));
/*      */     } finally {
/* 1937 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nsel_getName(long sel) {
/* 1945 */     long __functionAddress = Functions.sel_getName;
/* 1946 */     if (Checks.CHECKS) {
/* 1947 */       Checks.check(sel);
/*      */     }
/* 1949 */     return JNI.invokePP(sel, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("char const *")
/*      */   public static String sel_getName(@NativeType("SEL") long sel) {
/* 1955 */     long __result = nsel_getName(sel);
/* 1956 */     return MemoryUtil.memUTF8Safe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nsel_getUid(long str) {
/* 1963 */     long __functionAddress = Functions.sel_getUid;
/* 1964 */     return JNI.invokePP(str, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("SEL")
/*      */   public static long sel_getUid(@NativeType("char const *") ByteBuffer str) {
/* 1970 */     if (Checks.CHECKS) {
/* 1971 */       Checks.checkNT1(str);
/*      */     }
/* 1973 */     return nsel_getUid(MemoryUtil.memAddress(str));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("SEL")
/*      */   public static long sel_getUid(@NativeType("char const *") CharSequence str) {
/* 1979 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1981 */       stack.nUTF8(str, true);
/* 1982 */       long strEncoded = stack.getPointerAddress();
/* 1983 */       return nsel_getUid(strEncoded);
/*      */     } finally {
/* 1985 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nsel_registerName(long str) {
/* 1993 */     long __functionAddress = Functions.sel_registerName;
/* 1994 */     return JNI.invokePP(str, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("SEL")
/*      */   public static long sel_registerName(@NativeType("char const *") ByteBuffer str) {
/* 2000 */     if (Checks.CHECKS) {
/* 2001 */       Checks.checkNT1(str);
/*      */     }
/* 2003 */     return nsel_registerName(MemoryUtil.memAddress(str));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("SEL")
/*      */   public static long sel_registerName(@NativeType("char const *") CharSequence str) {
/* 2009 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2011 */       stack.nUTF8(str, true);
/* 2012 */       long strEncoded = stack.getPointerAddress();
/* 2013 */       return nsel_registerName(strEncoded);
/*      */     } finally {
/* 2015 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean sel_isEqual(@NativeType("SEL") long lhs, @NativeType("SEL") long rhs) {
/* 2024 */     long __functionAddress = Functions.sel_isEqual;
/* 2025 */     if (Checks.CHECKS) {
/* 2026 */       Checks.check(lhs);
/* 2027 */       Checks.check(rhs);
/*      */     } 
/* 2029 */     return JNI.invokePPZ(lhs, rhs, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void objc_enumerationMutation(@NativeType("id") long obj) {
/* 2036 */     long __functionAddress = Functions.objc_enumerationMutation;
/* 2037 */     if (Checks.CHECKS) {
/* 2038 */       Checks.check(obj);
/*      */     }
/* 2040 */     JNI.invokePV(obj, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nobjc_setEnumerationMutationHandler(long handler) {
/* 2047 */     long __functionAddress = Functions.objc_setEnumerationMutationHandler;
/* 2048 */     JNI.invokePV(handler, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void objc_setEnumerationMutationHandler(@NativeType("EnumerationMutationHandler") EnumerationMutationHandlerI handler) {
/* 2053 */     nobjc_setEnumerationMutationHandler(handler.address());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("IMP")
/*      */   public static long imp_implementationWithBlock(@NativeType("id") long block) {
/* 2061 */     long __functionAddress = Functions.imp_implementationWithBlock;
/* 2062 */     if (Checks.CHECKS) {
/* 2063 */       Checks.check(block);
/*      */     }
/* 2065 */     return JNI.invokePP(block, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("id")
/*      */   public static long imp_getBlock(@NativeType("IMP") long anImp) {
/* 2073 */     long __functionAddress = Functions.imp_getBlock;
/* 2074 */     if (Checks.CHECKS) {
/* 2075 */       Checks.check(anImp);
/*      */     }
/* 2077 */     return JNI.invokePP(anImp, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("BOOL")
/*      */   public static boolean imp_removeBlock(@NativeType("IMP") long anImp) {
/* 2085 */     long __functionAddress = Functions.imp_removeBlock;
/* 2086 */     if (Checks.CHECKS) {
/* 2087 */       Checks.check(anImp);
/*      */     }
/* 2089 */     return JNI.invokePZ(anImp, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_loadWeak(long location) {
/* 2096 */     long __functionAddress = Functions.objc_loadWeak;
/* 2097 */     return JNI.invokePP(location, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("id")
/*      */   public static long objc_loadWeak(@NativeType("id *") PointerBuffer location) {
/* 2103 */     if (Checks.CHECKS) {
/* 2104 */       Checks.checkSafe((CustomBuffer)location, 1);
/*      */     }
/* 2106 */     return nobjc_loadWeak(MemoryUtil.memAddressSafe((Pointer)location));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nobjc_storeWeak(long location, long obj) {
/* 2113 */     long __functionAddress = Functions.objc_storeWeak;
/* 2114 */     if (Checks.CHECKS) {
/* 2115 */       Checks.check(obj);
/*      */     }
/* 2117 */     return JNI.invokePPP(location, obj, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("id")
/*      */   public static long objc_storeWeak(@NativeType("id *") PointerBuffer location, @NativeType("id") long obj) {
/* 2123 */     if (Checks.CHECKS) {
/* 2124 */       Checks.check((CustomBuffer)location, 1);
/*      */     }
/* 2126 */     return nobjc_storeWeak(MemoryUtil.memAddress((CustomBuffer)location), obj);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void objc_setAssociatedObject(@NativeType("id") long object, @NativeType("void const *") long key, @NativeType("id") long value, @NativeType("objc_AssociationPolicy") long policy) {
/* 2133 */     long __functionAddress = Functions.objc_setAssociatedObject;
/* 2134 */     if (Checks.CHECKS) {
/* 2135 */       Checks.check(object);
/* 2136 */       Checks.check(key);
/* 2137 */       Checks.check(value);
/*      */     } 
/* 2139 */     JNI.invokePPPPV(object, key, value, policy, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("id")
/*      */   public static long objc_getAssociatedObject(@NativeType("id") long object, @NativeType("void const *") long key) {
/* 2147 */     long __functionAddress = Functions.objc_getAssociatedObject;
/* 2148 */     if (Checks.CHECKS) {
/* 2149 */       Checks.check(object);
/* 2150 */       Checks.check(key);
/*      */     } 
/* 2152 */     return JNI.invokePPP(object, key, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void objc_removeAssociatedObjects(@NativeType("id") long object) {
/* 2159 */     long __functionAddress = Functions.objc_removeAssociatedObjects;
/* 2160 */     if (Checks.CHECKS) {
/* 2161 */       Checks.check(object);
/*      */     }
/* 2163 */     JNI.invokePV(object, __functionAddress);
/*      */   }
/*      */   
/*      */   public static native void nprotocol_getMethodDescription(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, long paramLong3, long paramLong4);
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\macosx\ObjCRuntime.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */