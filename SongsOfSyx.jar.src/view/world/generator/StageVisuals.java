/*    */ package view.world.generator;
/*    */ 
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.gui.misc.GButt;
/*    */ import util.text.D;
/*    */ import util.text.Dic;
/*    */ import view.ui.profile.UIProfile;
/*    */ 
/*    */ class StageVisuals extends GuiSection {
/* 12 */   static CharSequence ¤¤title = "Customize Faction";
/*    */   
/*    */   static {
/* 15 */     D.ts(StageVisuals.class);
/*    */   }
/*    */ 
/*    */   
/*    */   StageVisuals(final WorldViewGenerator stages) {
/* 20 */     stages.reset();
/*    */     
/* 22 */     addRelBody(16, DIR.N, (RENDEROBJ)UIProfile.section(false));
/*    */     
/* 24 */     int p = 650 - body().width();
/* 25 */     if (p > 0) {
/* 26 */       pad(p / 2, 0);
/*    */     }
/* 28 */     addRelBody(16, DIR.S, (RENDEROBJ)(new GButt.ButtPanel(Dic.¤¤confirm)
/*    */         {
/*    */           protected void clickA() {
/* 31 */             stages.hasProfiled = true;
/* 32 */             stages.set();
/*    */           }
/* 35 */         }).hoverInfoSet(Dic.¤¤confirm));
/*    */     
/* 37 */     pad(0, 8);
/*    */     
/* 39 */     stages.dummy.add(this, ¤¤title);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\StageVisuals.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */