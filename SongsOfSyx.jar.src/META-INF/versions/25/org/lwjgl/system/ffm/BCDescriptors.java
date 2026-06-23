/*     */ package META-INF.versions.25.org.lwjgl.system.ffm;
/*     */ import java.lang.constant.ClassDesc;
/*     */ import java.lang.constant.ConstantDescs;
/*     */ import java.lang.constant.DirectMethodHandleDesc;
/*     */ import java.lang.constant.DynamicCallSiteDesc;
/*     */ import java.lang.constant.MethodHandleDesc;
/*     */ import java.lang.constant.MethodTypeDesc;
/*     */ import java.lang.foreign.Linker;
/*     */ import java.lang.foreign.MemorySegment;
/*     */ import java.lang.foreign.UnionLayout;
/*     */ import java.lang.foreign.ValueLayout;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.function.ToIntFunction;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.ffm.GroupBinder;
/*     */ import org.lwjgl.system.ffm.StructBinder;
/*     */ import org.lwjgl.system.ffm.TraceConsumer;
/*     */ import org.lwjgl.system.ffm.UpcallBinder;
/*     */ 
/*     */ final class BCDescriptors {
/*  22 */   static final ClassDesc CD_AddressLayout = AddressLayout.class.describeConstable().orElseThrow();
/*  23 */   static final ClassDesc CD_Arena = Arena.class.describeConstable().orElseThrow();
/*  24 */   static final ClassDesc CD_BiPredicate = BiPredicate.class.describeConstable().orElseThrow();
/*  25 */   static final ClassDesc CDA_byte = byte[].class.describeConstable().orElseThrow();
/*  26 */   static final ClassDesc CD_Charset = Charset.class.describeConstable().orElseThrow();
/*  27 */   static final ClassDesc CD_FFM = FFM.class.describeConstable().orElseThrow();
/*  28 */   static final ClassDesc CD_Function = Function.class.describeConstable().orElseThrow();
/*  29 */   static final ClassDesc CD_FunctionDescriptor = FunctionDescriptor.class.describeConstable().orElseThrow();
/*  30 */   static final ClassDesc CD_IllegalArgumentException = IllegalArgumentException.class.describeConstable().orElseThrow();
/*  31 */   static final ClassDesc CD_Group = Group.class.describeConstable().orElseThrow();
/*  32 */   static final ClassDesc CD_GroupBinder = GroupBinder.class.describeConstable().orElseThrow();
/*  33 */   static final ClassDesc CD_GroupLayout = GroupLayout.class.describeConstable().orElseThrow();
/*  34 */   static final ClassDesc CD_Linker = Linker.class.describeConstable().orElseThrow();
/*  35 */   static final ClassDesc CD_MemoryLayout = MemoryLayout.class.describeConstable().orElseThrow();
/*  36 */   static final ClassDesc CD_MemorySegment = MemorySegment.class.describeConstable().orElseThrow();
/*  37 */   static final ClassDesc CD_MemoryUtil = MemoryUtil.class.describeConstable().orElseThrow();
/*  38 */   static final ClassDesc CD_Method = Method.class.describeConstable().orElseThrow();
/*  39 */   static final ClassDesc CD_NullPointerException = NullPointerException.class.describeConstable().orElseThrow();
/*  40 */   static final ClassDesc CD_Record = Record.class.describeConstable().orElseThrow();
/*  41 */   static final ClassDesc CD_SegmentAllocator = SegmentAllocator.class.describeConstable().orElseThrow();
/*  42 */   static final ClassDesc CD_StackAllocator = StackAllocator.class.describeConstable().orElseThrow();
/*  43 */   static final ClassDesc CD_SegmentStack = SegmentStack.class.describeConstable().orElseThrow();
/*  44 */   static final ClassDesc CD_StandardCharsets = StandardCharsets.class.describeConstable().orElseThrow();
/*  45 */   static final ClassDesc CD_StructBinder = StructBinder.class.describeConstable().orElseThrow();
/*  46 */   static final ClassDesc CD_StructLayout = StructLayout.class.describeConstable().orElseThrow();
/*  47 */   static final ClassDesc CD_ToIntFunction = ToIntFunction.class.describeConstable().orElseThrow();
/*  48 */   static final ClassDesc CD_TraceConsumer = TraceConsumer.class.describeConstable().orElseThrow();
/*  49 */   static final ClassDesc CD_UnionBinder = UnionBinder.class.describeConstable().orElseThrow();
/*  50 */   static final ClassDesc CD_UnionLayout = UnionLayout.class.describeConstable().orElseThrow();
/*  51 */   static final ClassDesc CD_UpcallBinder = UpcallBinder.class.describeConstable().orElseThrow();
/*  52 */   static final ClassDesc CD_ValueLayout = ValueLayout.class.describeConstable().orElseThrow();
/*  53 */   static final ClassDesc CD_ValueLayout$OfByte = ValueLayout.OfByte.class.describeConstable().orElseThrow();
/*  54 */   static final ClassDesc CD_ValueLayout$OfShort = ValueLayout.OfShort.class.describeConstable().orElseThrow();
/*  55 */   static final ClassDesc CD_ValueLayout$OfInt = ValueLayout.OfInt.class.describeConstable().orElseThrow();
/*  56 */   static final ClassDesc CD_ValueLayout$OfLong = ValueLayout.OfLong.class.describeConstable().orElseThrow();
/*     */ 
/*     */   
/*  59 */   static final ClassDesc CDA_Linker$Option = ((ClassDesc)Linker.Option.class.describeConstable().orElseThrow()).arrayType();
/*  60 */   static final ClassDesc CDA_MethodHandle = ConstantDescs.CD_MethodHandle.arrayType();
/*  61 */   static final ClassDesc CDA_Object = ConstantDescs.CD_Object.arrayType();
/*  62 */   static final ClassDesc CDA_String = ConstantDescs.CD_String.arrayType();
/*     */ 
/*     */   
/*  65 */   static final MethodTypeDesc MTD_boolean_Object = MethodTypeDesc.of(ConstantDescs.CD_boolean, new ClassDesc[] { ConstantDescs.CD_Object });
/*  66 */   static final MethodTypeDesc MTD_boolean_Object_Object = MethodTypeDesc.of(ConstantDescs.CD_boolean, new ClassDesc[] { ConstantDescs.CD_Object, ConstantDescs.CD_Object });
/*  67 */   static final MethodTypeDesc MTD_byte_long = MethodTypeDesc.of(ConstantDescs.CD_byte, new ClassDesc[] { ConstantDescs.CD_long });
/*  68 */   static final MethodTypeDesc MTD_byte_ValueLayout$OfByte_long = MethodTypeDesc.of(ConstantDescs.CD_byte, new ClassDesc[] { CD_ValueLayout$OfByte, ConstantDescs.CD_long });
/*  69 */   static final MethodTypeDesc MTD_byteArray_Charset = MethodTypeDesc.of(CDA_byte, new ClassDesc[] { CD_Charset });
/*  70 */   static final MethodTypeDesc MTD_byteArray_ValueLayout$OfByte = MethodTypeDesc.of(CDA_byte, new ClassDesc[] { CD_ValueLayout$OfByte });
/*  71 */   static final MethodTypeDesc MTD_Charset_String = MethodTypeDesc.of(CD_Charset, new ClassDesc[] { ConstantDescs.CD_String });
/*  72 */   static final MethodTypeDesc MTD_double_long = MethodTypeDesc.of(ConstantDescs.CD_double, new ClassDesc[] { ConstantDescs.CD_long });
/*  73 */   static final MethodTypeDesc MTD_float_long = MethodTypeDesc.of(ConstantDescs.CD_float, new ClassDesc[] { ConstantDescs.CD_long });
/*  74 */   static final MethodTypeDesc MTD_FunctionDescriptor = MethodTypeDesc.of(CD_FunctionDescriptor);
/*  75 */   static final MethodTypeDesc MTD_Group = MethodTypeDesc.of(CD_Group);
/*  76 */   static final MethodTypeDesc MTD_Group_Group = MethodTypeDesc.of(CD_Group, new ClassDesc[] { CD_Group });
/*  77 */   static final MethodTypeDesc MTD_Group_MemorySegment = MethodTypeDesc.of(CD_Group, new ClassDesc[] { CD_MemorySegment });
/*  78 */   static final MethodTypeDesc MTD_Group_MemorySegment_long = MethodTypeDesc.of(CD_Group, new ClassDesc[] { CD_MemorySegment, ConstantDescs.CD_long });
/*  79 */   static final MethodTypeDesc MTD_GroupBinder_MemorySegment_Object = MethodTypeDesc.of(CD_GroupBinder, new ClassDesc[] { CD_MemorySegment, ConstantDescs.CD_Object });
/*  80 */   static final MethodTypeDesc MTD_GroupLayout = MethodTypeDesc.of(CD_GroupLayout);
/*  81 */   static final MethodTypeDesc MTD_int = MethodTypeDesc.of(ConstantDescs.CD_int);
/*  82 */   static final MethodTypeDesc MTD_int_long = MethodTypeDesc.of(ConstantDescs.CD_int, new ClassDesc[] { ConstantDescs.CD_long });
/*  83 */   static final MethodTypeDesc MTD_int_Object = MethodTypeDesc.of(ConstantDescs.CD_int, new ClassDesc[] { ConstantDescs.CD_Object });
/*  84 */   static final MethodTypeDesc MTD_int_ValueLayout$OfInt_long = MethodTypeDesc.of(ConstantDescs.CD_int, new ClassDesc[] { CD_ValueLayout$OfInt, ConstantDescs.CD_long });
/*  85 */   static final MethodTypeDesc MTD_Linker = MethodTypeDesc.of(CD_Linker);
/*  86 */   static final MethodTypeDesc MTD_Linker_upcallStub = MethodTypeDesc.of(CD_MemorySegment, new ClassDesc[] { ConstantDescs.CD_MethodHandle, CD_FunctionDescriptor, CD_Arena, CDA_Linker$Option });
/*  87 */   static final MethodTypeDesc MTD_long = MethodTypeDesc.of(ConstantDescs.CD_long);
/*  88 */   static final MethodTypeDesc MTD_long_long = MethodTypeDesc.of(ConstantDescs.CD_long, new ClassDesc[] { ConstantDescs.CD_long });
/*  89 */   static final MethodTypeDesc MTD_long_Object = MethodTypeDesc.of(ConstantDescs.CD_long, new ClassDesc[] { ConstantDescs.CD_Object });
/*  90 */   static final MethodTypeDesc MTD_long_ValueLayout$OfLong_long = MethodTypeDesc.of(ConstantDescs.CD_long, new ClassDesc[] { CD_ValueLayout$OfLong, ConstantDescs.CD_long });
/*  91 */   static final MethodTypeDesc MTD_MemoryLayout = MethodTypeDesc.of(CD_MemoryLayout);
/*  92 */   static final MethodTypeDesc MTD_MemorySegment_AddressLayout_long = MethodTypeDesc.of(CD_MemorySegment, new ClassDesc[] { CD_AddressLayout, ConstantDescs.CD_long });
/*  93 */   static final MethodTypeDesc MTD_MemorySegment_Arena_Object = MethodTypeDesc.of(CD_MemorySegment, new ClassDesc[] { CD_Arena, ConstantDescs.CD_Object });
/*  94 */   static final MethodTypeDesc MTD_MemorySegment_byte = MethodTypeDesc.of(CD_MemorySegment, new ClassDesc[] { ConstantDescs.CD_byte });
/*  95 */   static final MethodTypeDesc MTD_MemorySegment_long = MethodTypeDesc.of(CD_MemorySegment, new ClassDesc[] { ConstantDescs.CD_long });
/*  96 */   static final MethodTypeDesc MTD_MemorySegment_long_long = MethodTypeDesc.of(CD_MemorySegment, new ClassDesc[] { ConstantDescs.CD_long, ConstantDescs.CD_long });
/*  97 */   static final MethodTypeDesc MTD_MemorySegment_long_MemoryLayout = MethodTypeDesc.of(CD_MemorySegment, new ClassDesc[] { ConstantDescs.CD_long, CD_MemoryLayout });
/*  98 */   static final MethodTypeDesc MTD_MemorySegment_MemoryLayout_long = MethodTypeDesc.of(CD_MemorySegment, new ClassDesc[] { CD_MemoryLayout, ConstantDescs.CD_long });
/*  99 */   static final MethodTypeDesc MTD_MemorySegment_MemorySegment = MethodTypeDesc.of(CD_MemorySegment, new ClassDesc[] { CD_MemorySegment });
/* 100 */   static final MethodTypeDesc MTD_MemorySegment_MemorySegment_Object = MethodTypeDesc.of(CD_MemorySegment, new ClassDesc[] { CD_MemorySegment, ConstantDescs.CD_Object });
/* 101 */   static final MethodTypeDesc MTD_MemorySegment_Object = MethodTypeDesc.of(CD_MemorySegment, new ClassDesc[] { ConstantDescs.CD_Object });
/* 102 */   static final MethodTypeDesc MTD_MemorySegment_String_Charset = MethodTypeDesc.of(CD_MemorySegment, new ClassDesc[] { ConstantDescs.CD_String, CD_Charset });
/* 103 */   static final MethodTypeDesc MTD_MethodHandle = MethodTypeDesc.of(ConstantDescs.CD_MethodHandle);
/* 104 */   static final MethodTypeDesc MTD_MethodHandles$Lookup = MethodTypeDesc.of(ConstantDescs.CD_MethodHandles_Lookup);
/* 105 */   static final MethodTypeDesc MTD_MethodHandle_Class_String_MethodType = MethodTypeDesc.of(ConstantDescs.CD_MethodHandle, new ClassDesc[] { ConstantDescs.CD_Class, ConstantDescs.CD_String, ConstantDescs.CD_MethodType });
/* 106 */   static final MethodTypeDesc MTD_Object = MethodTypeDesc.of(ConstantDescs.CD_Object);
/* 107 */   static final MethodTypeDesc MTD_Object_long = MethodTypeDesc.of(ConstantDescs.CD_Object, new ClassDesc[] { ConstantDescs.CD_long });
/* 108 */   static final MethodTypeDesc MTD_Object_MemorySegment = MethodTypeDesc.of(ConstantDescs.CD_Object, new ClassDesc[] { CD_MemorySegment });
/* 109 */   static final MethodTypeDesc MTD_Object_MemorySegment_long = MethodTypeDesc.of(ConstantDescs.CD_Object, new ClassDesc[] { CD_MemorySegment, ConstantDescs.CD_long });
/* 110 */   static final MethodTypeDesc MTD_Object_Object = MethodTypeDesc.of(ConstantDescs.CD_Object, new ClassDesc[] { ConstantDescs.CD_Object });
/* 111 */   static final MethodTypeDesc MTD_Object_Object_Object = MethodTypeDesc.of(ConstantDescs.CD_Object, new ClassDesc[] { ConstantDescs.CD_Object, ConstantDescs.CD_Object });
/* 112 */   static final MethodTypeDesc MTD_short_long = MethodTypeDesc.of(ConstantDescs.CD_short, new ClassDesc[] { ConstantDescs.CD_long });
/* 113 */   static final MethodTypeDesc MTD_short_ValueLayout$OfShort_long = MethodTypeDesc.of(ConstantDescs.CD_short, new ClassDesc[] { CD_ValueLayout$OfShort, ConstantDescs.CD_long });
/* 114 */   static final MethodTypeDesc MTD_StackAllocator = MethodTypeDesc.of(CD_StackAllocator);
/* 115 */   static final MethodTypeDesc MTD_SegmentStack = MethodTypeDesc.of(CD_SegmentStack);
/* 116 */   static final MethodTypeDesc MTD_String = MethodTypeDesc.of(ConstantDescs.CD_String);
/* 117 */   static final MethodTypeDesc MTD_String_long = MethodTypeDesc.of(ConstantDescs.CD_String, new ClassDesc[] { ConstantDescs.CD_long });
/* 118 */   static final MethodTypeDesc MTD_String_long_Charset = MethodTypeDesc.of(ConstantDescs.CD_String, new ClassDesc[] { ConstantDescs.CD_long, CD_Charset });
/* 119 */   static final MethodTypeDesc MTD_String_String = MethodTypeDesc.of(ConstantDescs.CD_String, new ClassDesc[] { ConstantDescs.CD_String });
/* 120 */   static final MethodTypeDesc MTD_void_byteArray_Charset = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { CDA_byte, CD_Charset });
/* 121 */   static final MethodTypeDesc MTD_void_long = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { ConstantDescs.CD_long });
/* 122 */   static final MethodTypeDesc MTD_void_long_byte = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { ConstantDescs.CD_long, ConstantDescs.CD_byte });
/* 123 */   static final MethodTypeDesc MTD_void_long_short = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { ConstantDescs.CD_long, ConstantDescs.CD_short });
/* 124 */   static final MethodTypeDesc MTD_void_long_int = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { ConstantDescs.CD_long, ConstantDescs.CD_int });
/* 125 */   static final MethodTypeDesc MTD_void_long_long = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { ConstantDescs.CD_long, ConstantDescs.CD_long });
/* 126 */   static final MethodTypeDesc MTD_void_long_float = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { ConstantDescs.CD_long, ConstantDescs.CD_float });
/* 127 */   static final MethodTypeDesc MTD_void_long_double = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { ConstantDescs.CD_long, ConstantDescs.CD_double });
/* 128 */   static final MethodTypeDesc MTD_void_long_String_Charset = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { ConstantDescs.CD_long, ConstantDescs.CD_String, CD_Charset });
/* 129 */   static final MethodTypeDesc MTD_void_MemorySegment_long = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { CD_MemorySegment, ConstantDescs.CD_long });
/* 130 */   static final MethodTypeDesc MTD_void_Method_Object_ObjectArray = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { CD_Method, ConstantDescs.CD_Object, CDA_Object });
/* 131 */   static final MethodTypeDesc MTD_void_String = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { ConstantDescs.CD_String });
/* 132 */   static final MethodTypeDesc MTD_void_Object_int_MemorySegment_ValueLayout_long_int = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { ConstantDescs.CD_Object, ConstantDescs.CD_int, CD_MemorySegment, CD_ValueLayout, ConstantDescs.CD_long, ConstantDescs.CD_int });
/* 133 */   static final MethodTypeDesc MTD_void_Throwable = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { ConstantDescs.CD_Throwable });
/* 134 */   static final MethodTypeDesc MTD_void_ValueLayout$OfByte_long_byte = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { CD_ValueLayout$OfByte, ConstantDescs.CD_long, ConstantDescs.CD_byte });
/* 135 */   static final MethodTypeDesc MTD_void_ValueLayout$OfInt_long_int = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { CD_ValueLayout$OfInt, ConstantDescs.CD_long, ConstantDescs.CD_int });
/* 136 */   static final MethodTypeDesc MTD_void_ValueLayout$OfShort_long_short = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { CD_ValueLayout$OfShort, ConstantDescs.CD_long, ConstantDescs.CD_short });
/* 137 */   static final MethodTypeDesc MTD_void_ValueLayout$OfLong_long_long = MethodTypeDesc.of(ConstantDescs.CD_void, new ClassDesc[] { CD_ValueLayout$OfLong, ConstantDescs.CD_long, ConstantDescs.CD_long });
/*     */ 
/*     */   
/* 140 */   static final MethodTypeDesc MTD_Boolean_valueOf = MethodTypeDesc.of(ConstantDescs.CD_Boolean, new ClassDesc[] { ConstantDescs.CD_boolean });
/* 141 */   static final MethodTypeDesc MTD_Byte_valueOf = MethodTypeDesc.of(ConstantDescs.CD_Byte, new ClassDesc[] { ConstantDescs.CD_byte });
/* 142 */   static final MethodTypeDesc MTD_Short_valueOf = MethodTypeDesc.of(ConstantDescs.CD_Short, new ClassDesc[] { ConstantDescs.CD_short });
/* 143 */   static final MethodTypeDesc MTD_Integer_valueOf = MethodTypeDesc.of(ConstantDescs.CD_Integer, new ClassDesc[] { ConstantDescs.CD_int });
/* 144 */   static final MethodTypeDesc MTD_Long_valueOf = MethodTypeDesc.of(ConstantDescs.CD_Long, new ClassDesc[] { ConstantDescs.CD_long });
/* 145 */   static final MethodTypeDesc MTD_Float_valueOf = MethodTypeDesc.of(ConstantDescs.CD_Float, new ClassDesc[] { ConstantDescs.CD_float });
/* 146 */   static final MethodTypeDesc MTD_Double_valueOf = MethodTypeDesc.of(ConstantDescs.CD_Double, new ClassDesc[] { ConstantDescs.CD_double });
/*     */ 
/*     */   
/* 149 */   static final DirectMethodHandleDesc DMHD_FFM_bootstrapDowncall = ConstantDescs.ofConstantBootstrap(CD_FFM, "bootstrapDowncall", ConstantDescs.CD_MethodHandle, new ClassDesc[] { ConstantDescs.CD_int });
/* 150 */   static final DirectMethodHandleDesc DMHD_StringConcatFactory_makeConcatWithConstants = MethodHandleDesc.ofMethod(DirectMethodHandleDesc.Kind.STATIC, StringConcatFactory.class
/*     */       
/* 152 */       .describeConstable().orElseThrow(), "makeConcatWithConstants", 
/*     */       
/* 154 */       MethodTypeDesc.of(ConstantDescs.CD_CallSite, new ClassDesc[] { ConstantDescs.CD_MethodHandles_Lookup, ConstantDescs.CD_String, ConstantDescs.CD_MethodType, ConstantDescs.CD_String, CDA_Object }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 163 */   static final DirectMethodHandleDesc DMHD_GroupBinder_bootstrapRecord = MethodHandleDesc.ofMethod(DirectMethodHandleDesc.Kind.INTERFACE_STATIC, CD_GroupBinder, "bootstrapRecord", 
/*     */ 
/*     */ 
/*     */       
/* 167 */       MethodTypeDesc.of(ConstantDescs.CD_Object, new ClassDesc[] {
/*     */ 
/*     */ 
/*     */           
/* 171 */           ConstantDescs.CD_MethodHandles_Lookup, ConstantDescs.CD_String, TypeDescriptor.class.describeConstable().orElseThrow(), ConstantDescs.CD_String, CDA_String
/*     */         }));
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 177 */   static final DynamicCallSiteDesc DCSD_StringConcatFactory_makeConcatWithConstants_AddressToHexString = DynamicCallSiteDesc.of(DMHD_StringConcatFactory_makeConcatWithConstants, "makeConcatWithConstants", MTD_String_String, (ConstantDesc[])new String[] { "0x\001" });
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\BCDescriptors.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */