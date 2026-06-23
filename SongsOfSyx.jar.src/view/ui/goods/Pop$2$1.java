/*    */ package view.ui.goods;
/*    */ 
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import util.data.GETTER;
/*    */ import view.main.VIEW;
/*    */ import world.map.regions.Region;
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
/*    */ class null
/*    */   extends GuiSection
/*    */ {
/*    */   protected void clickA() {
/* 40 */     Region r = (Region)(Pop.null.access$0(Pop.null.this)).regs.get(((Integer)ier.get()).intValue());
/* 41 */     if (r != null) {
/* 42 */       (VIEW.UI()).manager.close();
/* 43 */       VIEW.world().activate();
/* 44 */       (VIEW.world()).UI.regions.open(r);
/*    */     } 
/*    */     
/* 47 */     super.clickA();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\Pop$2$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */