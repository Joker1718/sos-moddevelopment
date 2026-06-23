/*     */ package view.ui.wiki;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.TERRAIN;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends WikiRace.RGauge
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/* 127 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   double getValue() {
/* 131 */     return (WikiRace.this.race.population()).max * WikiRace.this.race.population().terrain(c) / maxAm;
/*     */   }
/*     */ 
/*     */   
/*     */   SPRITE get(double value) {
/* 136 */     return (SPRITE)(SPRITES.icons()).s.human;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 142 */     GBox b = (GBox)text;
/*     */     
/* 144 */     b.title(c.name);
/* 145 */     b.text(c.desc);
/*     */     
/* 147 */     b.NL(8);
/*     */     
/* 149 */     b.textLL(WikiRace.this.race.info.names);
/* 150 */     b.add((SPRITE)GFORMAT.percBig(b.text(), (WikiRace.this.race.population()).max * WikiRace.this.race.population().terrain(c)));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\wiki\WikiRace$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */