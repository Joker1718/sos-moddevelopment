/*    */ package view.world.generator;
/*    */ 
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import util.gui.misc.GButt;
/*    */ import view.tool.PLACABLE;
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
/*    */ class B
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   private final PLACABLE p;
/*    */   private final WorldViewGenerator stages;
/*    */   
/*    */   public B(PLACABLE p, WorldViewGenerator stages) {
/* 67 */     super(p.getIcon());
/* 68 */     this.p = p;
/* 69 */     this.stages = stages;
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 74 */     text.title(this.p.name());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 79 */     selectedSet((this.stages.tools.placer.isActivated() && (this.stages.tools.placer.getCurrent() == this.p || this.stages.tools.placer.getCurrent() == this.p.getUndo())));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 84 */     this.stages.tools.place(this.p);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\StageEdit$B.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */