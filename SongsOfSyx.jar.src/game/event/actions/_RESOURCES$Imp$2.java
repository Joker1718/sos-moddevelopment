/*     */ package game.event.actions;
/*     */ 
/*     */ import game.event.engine.EContext;
/*     */ import game.event.engine.Event;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
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
/*     */ class null
/*     */   extends GStat
/*     */ {
/*     */   public void update(GText text) {
/*  94 */     GFORMAT.i(text, d.amount.get(event, data));
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/*  99 */     b.title(d.t.names);
/* 100 */     int ava = d.t.ps().playerOwned();
/* 101 */     if (d.amount.get(event, data) < 0) {
/* 102 */       b.textLL(Dic.¤¤Needed);
/* 103 */       b.tab(6);
/* 104 */       GText t = b.text();
/* 105 */       b.add((SPRITE)GFORMAT.i(t, d.amount.get(event, data)));
/* 106 */       if (ava < -d.amount.get(event, data))
/* 107 */         t.errorify(); 
/* 108 */       b.NL();
/*     */     } 
/*     */     
/* 111 */     b.textLL(Dic.¤¤Available);
/* 112 */     b.tab(6);
/*     */     
/* 114 */     b.add((SPRITE)GFORMAT.i(b.text(), ava));
/* 115 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_RESOURCES$Imp$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */