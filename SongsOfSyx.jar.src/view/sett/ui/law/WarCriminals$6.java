/*     */ package view.sett.ui.law;
/*     */ 
/*     */ import init.type.CRIMES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.law.StatCrime;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/* 257 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void clickA() {
/* 261 */     ((StatCrime)(STATS.LAW()).crimes.get(CRIMES.WAR().index())).punishmentSet(HCLASSES.OTHER(), WarCriminals.this.sel.getRace(), punish);
/* 262 */     super.clickA();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 267 */     selectedSet(((((StatCrime)(STATS.LAW()).crimes.get(CRIMES.WAR().index())).punishment(HCLASSES.OTHER(), WarCriminals.this.sel.getRace())).punish == punish));
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 272 */     GBox b = (GBox)text;
/* 273 */     b.title(punish.action);
/* 274 */     b.text(punish.desc);
/* 275 */     b.sep();
/*     */     
/* 277 */     b.add(((STATS.BATTLE()).CHIVALRY.info()).icon);
/* 278 */     b.textLL(((STATS.BATTLE()).CHIVALRY.info()).name);
/* 279 */     b.tab(6);
/* 280 */     b.add((SPRITE)GFORMAT.perc(b.text(), punish.mercyValue(HCLASSES.OTHER(), WarCriminals.this.sel.getRace())));
/* 281 */     b.tab(8);
/* 282 */     b.text((CharSequence)b.text().add(WarCriminals.¤¤per100).insert(0, 100.0D * punish.mercyPerPerson(HCLASSES.OTHER(), WarCriminals.this.sel.getRace()), 4));
/* 283 */     b.NL(8);
/*     */     
/* 285 */     b.add(((STATS.BATTLE()).CRUELTY.info()).icon);
/* 286 */     b.textLL(((STATS.BATTLE()).CRUELTY.info()).name);
/* 287 */     b.tab(6);
/* 288 */     b.add((SPRITE)GFORMAT.perc(b.text(), punish.crueltyValue(HCLASSES.OTHER(), WarCriminals.this.sel.getRace())));
/* 289 */     b.NL();
/* 290 */     b.text((CharSequence)b.text().add(WarCriminals.¤¤per100).insert(0, 100.0D * punish.crueltyPerPerson(HCLASSES.OTHER(), WarCriminals.this.sel.getRace()), 4));
/* 291 */     b.NL();
/*     */ 
/*     */     
/* 294 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\law\WarCriminals$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */