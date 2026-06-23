/*    */ package view.sett.ui.food;
/*    */ 
/*    */ import init.resources.RESOURCES;
/*    */ import init.resources.ResG;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.Dic;
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
/*    */ class null
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 63 */     double am = 0.0D;
/* 64 */     for (ResG rr : RESOURCES.EDI().all()) {
/* 65 */       am += (SETT.ROOMS()).PROD.produced(rr.resource);
/*    */     }
/*    */     
/* 68 */     GFORMAT.f0(text, am);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 74 */     double am = 0.0D;
/* 75 */     for (ResG rr : RESOURCES.EDI().all()) {
/* 76 */       b.add((SPRITE)rr.resource.icon());
/* 77 */       b.textL(rr.resource.name);
/* 78 */       b.tab(7);
/* 79 */       double a = (SETT.ROOMS()).PROD.produced(rr.resource);
/*    */       
/* 81 */       b.add((SPRITE)GFORMAT.f0(b.text(), a));
/* 82 */       b.NL();
/* 83 */       am += a;
/*    */     } 
/*    */     
/* 86 */     b.NL(8);
/*    */     
/* 88 */     b.textLL(Dic.¤¤Total);
/* 89 */     b.tab(7);
/*    */     
/* 91 */     b.add((SPRITE)GFORMAT.f0(b.text(), am));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\food\UIFood$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */