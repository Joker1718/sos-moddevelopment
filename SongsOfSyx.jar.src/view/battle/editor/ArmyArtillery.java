/*    */ package view.battle.editor;
/*    */ 
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.DOUBLE;
/*    */ import util.data.GETTER;
/*    */ import util.data.INT;
/*    */ import util.gui.slider.GTarget;
/*    */ import world.army.AD;
/*    */ import world.army.ADSupplies;
/*    */ 
/*    */ 
/*    */ public class ArmyArtillery
/*    */   extends GuiSection
/*    */ {
/*    */   ArmyArtillery(final GETTER.GETTER_IMP<ArmySide> current) {
/* 18 */     for (ADSupplies.ADArtillery a : AD.supplies().arts()) {
/*    */       
/* 20 */       INT.INTE ii = new INT.INTE()
/*    */         {
/*    */           public int min()
/*    */           {
/* 24 */             return 0;
/*    */           }
/*    */ 
/*    */           
/*    */           public int max() {
/* 29 */             return 40;
/*    */           }
/*    */ 
/*    */           
/*    */           public int get() {
/* 34 */             return ((ArmySide)current.get()).artillery[a.index()];
/*    */           }
/*    */ 
/*    */           
/*    */           public void set(int t) {
/* 39 */             ((ArmySide)current.get()).artillery[a.index()] = t;
/*    */           }
/*    */         };
/*    */       
/* 43 */       GuiSection s = new GuiSection();
/* 44 */       s.hoverInfoSet(a.art.info.names);
/* 45 */       add((SPRITE)a.art.icon, 0, 0);
/* 46 */       addRightC(8, (RENDEROBJ)new GTarget(48, true, true, ii));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\editor\ArmyArtillery.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */