/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.type.HCLASS;
/*     */ import init.type.NEEDS;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsReligion;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.table.GStaples;
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
/*     */ class null
/*     */   extends GStaples
/*     */ {
/*     */   null(int $anonymous0) {
/* 146 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void hover(GBox box, int stapleI) {
/* 150 */     box.title((((StatsReligion.StatReligion)(STATS.RELIGION()).ALL.get(0)).followers.info()).name);
/* 151 */     int i = 32 - stapleI - 1;
/* 152 */     box.add((SPRITE)box.text().add(-i).s().add(TIME.days().cycleName()));
/* 153 */     box.NL(8);
/*     */     
/* 155 */     for (StatsReligion.StatReligion s : (STATS.RELIGION()).ALL) {
/* 156 */       box.add((SPRITE)s.religion.icon);
/* 157 */       box.textLL(s.religion.info.name);
/* 158 */       box.tab(6);
/* 159 */       box.add((SPRITE)GFORMAT.i(box.text(), s.followers.data(cl).get(race.get(), i)));
/* 160 */       box.tab(8);
/* 161 */       if (i < 31)
/* 162 */         box.add((SPRITE)GFORMAT.iIncr(box.text(), (s.followers.data(cl).get(race.get(), i) - s.followers.data(cl).get(race.get(), i + 1)))); 
/* 163 */       box.NL();
/*     */     } 
/*     */     
/* 166 */     box.add((SPRITE)(NEEDS.TYPES()).SHRINE.rate.icon);
/* 167 */     box.textLL(((STATS.RELIGION()).SHRINE.TOTAL.info()).name);
/* 168 */     box.tab(6);
/* 169 */     box.add((SPRITE)GFORMAT.perc(box.text(), (STATS.RELIGION()).SHRINE.TOTAL.data(cl).getD(race.get()), i));
/* 170 */     if (i < 31)
/* 171 */       box.add((SPRITE)GFORMAT.percInc(box.text(), (STATS.RELIGION()).SHRINE.TOTAL.data(cl).getD(race.get(), i) - (STATS.RELIGION()).SHRINE.TOTAL.data(cl).getD(race.get(), i + 1))); 
/* 172 */     box.NL();
/*     */     
/* 174 */     box.add((SPRITE)(NEEDS.TYPES()).TEMPLE.rate.icon);
/* 175 */     box.textLL(((STATS.RELIGION()).TEMPLE.TOTAL.info()).name);
/* 176 */     box.tab(6);
/* 177 */     box.add((SPRITE)GFORMAT.perc(box.text(), (STATS.RELIGION()).TEMPLE.TOTAL.data(cl).getD(race.get()), i));
/* 178 */     if (i < 31)
/* 179 */       box.add((SPRITE)GFORMAT.percInc(box.text(), (STATS.RELIGION()).TEMPLE.TOTAL.data(cl).getD(race.get(), i) - (STATS.RELIGION()).TEMPLE.TOTAL.data(cl).getD(race.get(), i + 1))); 
/* 180 */     box.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   protected double getValue(int stapleI) {
/* 185 */     int i = 32 - stapleI - 1;
/* 186 */     return (STATS.POP()).POP.data(cl).get(race.get(), i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderExtra(SPRITE_RENDERER r, COLOR color, int stapleI, boolean hovered, double value, int x1, int x2, int y1, int y2) {
/* 194 */     int i = 32 - stapleI - 1;
/*     */     
/* 196 */     int h = y2 - y1;
/* 197 */     if (h <= 0) {
/* 198 */       h = 1;
/*     */     }
/* 200 */     for (StatsReligion.StatReligion s : (STATS.RELIGION()).ALL) {
/* 201 */       int hh = (int)Math.ceil(h * s.followers.data(cl).getD(race.get(), i));
/* 202 */       if (hh > 0) {
/* 203 */         ColorImp c = ColorImp.TMP;
/* 204 */         c.set(s.religion.color);
/* 205 */         c.shadeSelf(hovered ? 0.75D : 0.55D);
/* 206 */         c.render(r, x1, x2, y2 - hh, y2);
/* 207 */         c.set(s.religion.color);
/* 208 */         c.shadeSelf(hovered ? 1.0D : 0.8D);
/* 209 */         c.render(r, x1 + 1, x2 - 1, y2 - hh + 1, y2 - 1);
/* 210 */         y2 -= hh;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatReligion$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */