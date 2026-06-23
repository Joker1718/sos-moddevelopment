/*     */ package settlement.room.infra.station;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
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
/* 108 */     GFORMAT.perc(text, ((StationInstance)g.get()).efficiency() * Gui.this.bonus((StationInstance)g.get()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/* 113 */     b.title(Gui.¤¤efficiency);
/* 114 */     b.text(Gui.¤¤efficiencyD);
/* 115 */     b.NL();
/* 116 */     b.add((SPRITE)((SETT.ROOMS()).STOCKPILE.bonus()).icon);
/* 117 */     b.textLL(((SETT.ROOMS()).STOCKPILE.bonus()).name);
/* 118 */     b.tab(6);
/* 119 */     GText t = b.text();
/* 120 */     t.add('x').s();
/* 121 */     GFORMAT.f1(t, Gui.this.bonus((StationInstance)g.get()));
/* 122 */     b.add((SPRITE)t);
/* 123 */     b.NL(8);
/*     */     
/* 125 */     t = b.text();
/* 126 */     t.add(Gui.¤¤efficiencyD2);
/* 127 */     t.insert(0, ((StationInstance)g.get()).efficiency() * Gui.this.bonus((StationInstance)g.get()), 2);
/* 128 */     t.insert(1, 400);
/* 129 */     t.insert(2, (int)(((StationInstance)g.get()).efficiency() * Gui.this.bonus((StationInstance)g.get()) * 400.0D));
/* 130 */     b.add((SPRITE)t);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\station\Gui$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */