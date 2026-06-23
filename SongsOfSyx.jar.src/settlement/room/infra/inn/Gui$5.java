/*     */ package settlement.room.infra.inn;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.DicTime;
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
/*     */   extends GStaples
/*     */ {
/*     */   null(int $anonymous0) {
/* 135 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void hover(GBox box, int stapleI) {
/* 139 */     int ago = am - 1 - stapleI;
/* 140 */     GText t = box.text();
/* 141 */     DicTime.setAgo((Str)t, ago * (FACTIONS.player().credits().get(FCredits.CTYPE.TOURISM)).IN.time().bitSeconds());
/* 142 */     box.textLL((CharSequence)t);
/* 143 */     box.NL();
/* 144 */     box.add((SPRITE)GFORMAT.iIncr(box.text(), (FACTIONS.player().credits().get(FCredits.CTYPE.TOURISM)).IN.get(ago)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected double getValue(int stapleI) {
/* 150 */     return (FACTIONS.player().credits().get(FCredits.CTYPE.TOURISM)).IN.get(am - 1 - stapleI);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\inn\Gui$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */