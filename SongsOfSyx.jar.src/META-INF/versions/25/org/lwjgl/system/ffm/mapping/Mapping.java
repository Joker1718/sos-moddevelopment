/*     */ package META-INF.versions.25.org.lwjgl.system.ffm.mapping;
/*     */ 
/*     */ import java.lang.foreign.MemoryLayout;
/*     */ import java.lang.foreign.ValueLayout;
/*     */ import org.lwjgl.system.ffm.mapping.IntegerMappings;
/*     */ import org.lwjgl.system.ffm.mapping.PrimitiveMappings;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface Mapping<L extends MemoryLayout>
/*     */ {
/*     */   L layout();
/*     */   
/*     */   org.lwjgl.system.ffm.mapping.Mapping<L> typedef(String paramString);
/*     */   
/*     */   org.lwjgl.system.ffm.mapping.Mapping<L> cconst();
/*     */   
/*     */   default Pointer p() {
/*  42 */     return new Pointer((MemoryLayout)layout());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Opaque createOpaque(String name) {
/*  53 */     return new Opaque(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Boolean createBoolean(String name) {
/*  63 */     return PrimitiveMappings.create(ValueLayout.JAVA_BOOLEAN.withName(name));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Byte createByte(String name, boolean signed) {
/*  72 */     return IntegerMappings.create(ValueLayout.JAVA_BYTE.withName(name), signed);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Char createChar(String name) {
/*  81 */     return IntegerMappings.create(ValueLayout.JAVA_CHAR.withName(name));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Short createShort(String name, boolean signed) {
/*  90 */     return IntegerMappings.create(ValueLayout.JAVA_SHORT.withName(name), signed);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Int createInt(String name, boolean signed) {
/*  99 */     return IntegerMappings.create(ValueLayout.JAVA_INT.withName(name), signed);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Long createLong(String name, boolean signed) {
/* 108 */     return IntegerMappings.create(ValueLayout.JAVA_LONG.withName(name), signed);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static CLong createCLong(String name, boolean signed) {
/* 117 */     return IntegerMappings.createCLong(name, signed);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Size createSize(String name, boolean signed) {
/* 126 */     return IntegerMappings.create(ValueLayout.ADDRESS.withName(name), signed);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Float createFloat(String name) {
/* 135 */     return PrimitiveMappings.create(ValueLayout.JAVA_FLOAT.withName(name));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Double createDouble(String name) {
/* 144 */     return PrimitiveMappings.create(ValueLayout.JAVA_DOUBLE.withName(name));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\mapping\Mapping.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */