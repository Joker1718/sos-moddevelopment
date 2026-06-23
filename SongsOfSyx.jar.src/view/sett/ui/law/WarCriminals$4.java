/*     */ package view.sett.ui.law;
/*     */ 
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GuiSection
/*     */ {
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 149 */     GBox b = (GBox)text;
/* 150 */     b.title(punish.action);
/* 151 */     b.text(WarCriminals.¤¤assign);
/* 152 */     b.NL();
/*     */     
/* 154 */     b.add(((STATS.BATTLE()).CHIVALRY.info()).icon);
/* 155 */     b.textLL(((STATS.BATTLE()).CHIVALRY.info()).name);
/* 156 */     b.tab(6);
/* 157 */     b.add((SPRITE)GFORMAT.perc(b.text(), punish.mercyValue(HCLASSES.OTHER(), WarCriminals.this.sel.getRace())));
/* 158 */     b.NL();
/*     */     
/* 160 */     b.add(((STATS.BATTLE()).CRUELTY.info()).icon);
/* 161 */     b.textLL(((STATS.BATTLE()).CRUELTY.info()).name);
/* 162 */     b.tab(6);
/* 163 */     b.add((SPRITE)GFORMAT.perc(b.text(), punish.crueltyValue(HCLASSES.OTHER(), WarCriminals.this.sel.getRace())));
/* 164 */     b.NL();
/*     */     
/* 166 */     b.sep();
/*     */ 
/*     */     
/* 169 */     b.NL(8);
/* 170 */     b.textLL(WarCriminals.¤¤selected);
/* 171 */     b.tab(6);
/* 172 */     b.add((SPRITE)GFORMAT.i(b.text(), ii.get()));
/* 173 */     b.NL();
/*     */ 
/*     */     
/* 176 */     b.add(((STATS.BATTLE()).CHIVALRY.info()).icon);
/* 177 */     b.textLL(((STATS.BATTLE()).CHIVALRY.info()).name);
/* 178 */     b.tab(6);
/* 179 */     b.text((CharSequence)GFORMAT.f0(b.text(), ii.get() * punish.mercyPerPerson(HCLASSES.OTHER(), WarCriminals.this.sel.getRace())));
/* 180 */     b.NL();
/*     */     
/* 182 */     b.add(((STATS.BATTLE()).CRUELTY.info()).icon);
/* 183 */     b.textLL(((STATS.BATTLE()).CRUELTY.info()).name);
/* 184 */     b.tab(6);
/* 185 */     b.text((CharSequence)GFORMAT.f0(b.text(), ii.get() * punish.crueltyPerPerson(HCLASSES.OTHER(), WarCriminals.this.sel.getRace())));
/* 186 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\law\WarCriminals$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */