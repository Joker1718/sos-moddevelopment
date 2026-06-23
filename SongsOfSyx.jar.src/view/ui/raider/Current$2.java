/*    */ package view.ui.raider;
/*    */ 
/*    */ import game.GAME;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.colors.GCOLOR;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.text.DicTime;
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
/*    */ class null
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 70 */     text.setMaxWidth(700);
/* 71 */     text.setMultipleLines(true);
/* 72 */     if ((GAME.raiders()).current.current() == Current.this.rr()) {
/* 73 */       text.color((GCOLOR.T()).IBAD).add(Current.¤¤raidingD);
/* 74 */     } else if ((Current.this.rr()).defeated) {
/* 75 */       Str.TMP.clear();
/* 76 */       DicTime.setDate(Str.TMP.clear(), (int)(Current.this.rr()).secondDefeated);
/* 77 */       text.add(Current.¤¤killed);
/* 78 */       text.insert(0, (CharSequence)Str.TMP);
/* 79 */       text.color((GCOLOR.T()).IGREAT);
/* 80 */     } else if (!Current.this.rr().hasInterrest()) {
/* 81 */       text.color((GCOLOR.T()).WARNING).add(Current.¤¤distantD);
/* 82 */     } else if (Current.this.rr().isScared()) {
/* 83 */       text.color((GCOLOR.T()).WARNING).add(Current.¤¤hidingD);
/*    */     } else {
/* 85 */       text.color((GCOLOR.T()).IBAD).add(Current.¤¤atLargeD);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\raider\Current$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */