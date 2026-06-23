/*     */ package META-INF.versions.25.org.lwjgl.system.ffm.mapping;
/*     */ 
/*     */ import java.lang.foreign.AddressLayout;
/*     */ import java.lang.foreign.ValueLayout;
/*     */ import org.lwjgl.system.Platform;
/*     */ import org.lwjgl.system.ffm.mapping.Mapping;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class IntegerMappings
/*     */ {
/*     */   static Mapping.Byte create(ValueLayout.OfByte layout, boolean signed) {
/*  16 */     Mapping.Pointer p = new Mapping.Pointer(layout);
/*  17 */     return signed ? 
/*  18 */       (Mapping.Byte)new ByteS(layout, p) : 
/*  19 */       (Mapping.Byte)new ByteU(layout, p);
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
/*     */   static Mapping.Char create(ValueLayout.OfChar layout) {
/*  33 */     return new Mapping.Char(layout, new Mapping.Pointer(layout));
/*     */   }
/*     */   
/*     */   static Mapping.Short create(ValueLayout.OfShort layout, boolean signed) {
/*  37 */     Mapping.Pointer p = new Mapping.Pointer(layout);
/*  38 */     return signed ? 
/*  39 */       (Mapping.Short)new ShortS(layout, p) : 
/*  40 */       (Mapping.Short)new ShortU(layout, p);
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
/*     */   static Mapping.Int create(ValueLayout.OfInt layout, boolean signed) {
/*  54 */     Mapping.Pointer p = new Mapping.Pointer(layout);
/*  55 */     return signed ? 
/*  56 */       (Mapping.Int)new IntS(layout, p) : 
/*  57 */       (Mapping.Int)new IntU(layout, p);
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
/*     */   static Mapping.Long create(ValueLayout.OfLong layout, boolean signed) {
/*  71 */     Mapping.Pointer p = new Mapping.Pointer(layout);
/*  72 */     return signed ? 
/*  73 */       (Mapping.Long)new LongS(layout, p) : 
/*  74 */       (Mapping.Long)new LongU(layout, p);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  83 */   private static final boolean CLONG32 = (ValueLayout.ADDRESS.byteSize() == 4L || Platform.get() == Platform.WINDOWS);
/*     */   static Mapping.CLong createCLong(String name, boolean signed) {
/*  85 */     if (CLONG32) {
/*  86 */       ValueLayout.OfInt ofInt = ValueLayout.JAVA_INT.withName(name);
/*  87 */       Mapping.Pointer pointer = new Mapping.Pointer(ofInt);
/*  88 */       return signed ? 
/*  89 */         (Mapping.CLong)new CLong32S(ofInt, pointer) : 
/*  90 */         (Mapping.CLong)new CLong32U(ofInt, pointer);
/*     */     } 
/*  92 */     ValueLayout.OfLong layout = ValueLayout.JAVA_LONG.withName(name);
/*  93 */     Mapping.Pointer p = new Mapping.Pointer(layout);
/*  94 */     return (Mapping.CLong)new CLong64Impl(layout, p, signed);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Mapping.Size create(AddressLayout layout, boolean signed) {
/* 212 */     Mapping.Pointer p = new Mapping.Pointer(layout);
/* 213 */     return signed ? 
/* 214 */       (Mapping.Size)new SizeS(layout, p) : 
/* 215 */       (Mapping.Size)new SizeU(layout, p);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\mapping\IntegerMappings.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */