/*    */ package META-INF.versions.25.org.lwjgl.system.ffm.mapping;
/*    */ 
/*    */ import java.lang.foreign.ValueLayout;
/*    */ import org.lwjgl.system.ffm.mapping.Mapping;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class PrimitiveMappings
/*    */ {
/*    */   static Mapping.Boolean create(ValueLayout.OfBoolean layout) {
/* 13 */     return new Mapping.Boolean(layout, new Mapping.Pointer(layout));
/* 14 */   } static Mapping.Float create(ValueLayout.OfFloat layout) { return new Mapping.Float(layout, new Mapping.Pointer(layout)); } static Mapping.Double create(ValueLayout.OfDouble layout) {
/* 15 */     return new Mapping.Double(layout, new Mapping.Pointer(layout));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\mapping\PrimitiveMappings.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */