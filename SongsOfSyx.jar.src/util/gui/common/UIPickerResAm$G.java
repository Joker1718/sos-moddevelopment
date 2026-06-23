/*    */ package util.gui.common;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import util.data.GETTER;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class G
/*    */   implements GETTER<RESOURCE>
/*    */ {
/*    */   private final GETTER<Integer> ier;
/*    */   
/*    */   G(GETTER<Integer> ier) {
/* 75 */     this.ier = ier;
/*    */   }
/*    */ 
/*    */   
/*    */   public RESOURCE get() {
/* 80 */     return (RESOURCE)RESOURCES.ALL().get(UIPickerResAm.this.all.get(((Integer)this.ier.get()).intValue()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\UIPickerResAm$G.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */