/*    */ package view.world.generator;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.BODY_HOLDER;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
/*    */ import util.gui.panel.GPanel;
/*    */ import util.text.D;
/*    */ import view.tool.PLACABLE;
/*    */ import world.WORLD;
/*    */ 
/*    */ class StageEdit {
/* 16 */   static CharSequence ¤¤name = "Edit terrain";
/*    */   static {
/* 18 */     D.ts(StageEdit.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public StageEdit(final WorldViewGenerator stages) {
/* 23 */     GuiSection s = new GuiSection()
/*    */       {
/*    */         public void render(SPRITE_RENDERER r, float ds)
/*    */         {
/* 27 */           (WORLD.OVERLAY()).landmarks.add();
/* 28 */           super.render(r, ds);
/*    */         }
/*    */       };
/*    */ 
/*    */     
/* 33 */     PLACABLE first = null;
/* 34 */     for (PLACABLE pLACABLE : WORLD.TERRAIN().saver().makePlacers(stages.tools)) {
/* 35 */       if (first == null)
/* 36 */         first = pLACABLE; 
/* 37 */       s.addRightC(0, (RENDEROBJ)new B(pLACABLE, stages));
/*    */     } 
/*    */ 
/*    */     
/* 41 */     s.addRightC(16, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.ok)
/*    */         {
/*    */           protected void clickA() {
/* 44 */             stages.set();
/*    */           }
/*    */         });
/*    */     
/* 48 */     GPanel p = new GPanel();
/* 49 */     p.inner().set((BODY_HOLDER)s);
/* 50 */     s.add((RENDEROBJ)p);
/* 51 */     s.moveLastToBack();
/* 52 */     s.body().centerIn(C.DIM());
/* 53 */     s.body().moveY1(5.0D);
/*    */     
/* 55 */     stages.dummy.add(s, null, false);
/* 56 */     s.body().moveY1(10.0D);
/*    */     
/* 58 */     stages.tools.place(first);
/*    */   }
/*    */   
/*    */   private static class B
/*    */     extends GButt.ButtPanel {
/*    */     private final PLACABLE p;
/*    */     private final WorldViewGenerator stages;
/*    */     
/*    */     public B(PLACABLE p, WorldViewGenerator stages) {
/* 67 */       super(p.getIcon());
/* 68 */       this.p = p;
/* 69 */       this.stages = stages;
/*    */     }
/*    */ 
/*    */     
/*    */     public void hoverInfoGet(GUI_BOX text) {
/* 74 */       text.title(this.p.name());
/*    */     }
/*    */ 
/*    */     
/*    */     protected void renAction() {
/* 79 */       selectedSet((this.stages.tools.placer.isActivated() && (this.stages.tools.placer.getCurrent() == this.p || this.stages.tools.placer.getCurrent() == this.p.getUndo())));
/*    */     }
/*    */ 
/*    */     
/*    */     protected void clickA() {
/* 84 */       this.stages.tools.place(this.p);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\StageEdit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */