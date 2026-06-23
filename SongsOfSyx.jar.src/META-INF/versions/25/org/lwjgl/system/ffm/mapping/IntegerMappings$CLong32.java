/*     */ package META-INF.versions.25.org.lwjgl.system.ffm.mapping;
/*     */ 
/*     */ import java.lang.foreign.ValueLayout;
/*     */ import org.lwjgl.system.ffm.mapping.IntegerMappings;
/*     */ import org.lwjgl.system.ffm.mapping.Mapping;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ interface CLong32
/*     */   extends Mapping.CLong
/*     */ {
/*     */   static Mapping.CLong create(ValueLayout.OfInt layout, boolean signed) {
/* 100 */     Mapping.Pointer p = new Mapping.Pointer(layout);
/* 101 */     return signed ? 
/* 102 */       (Mapping.CLong)new IntegerMappings.CLong32S(layout, p) : 
/* 103 */       (Mapping.CLong)new IntegerMappings.CLong32U(layout, p);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\mapping\IntegerMappings$CLong32.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */