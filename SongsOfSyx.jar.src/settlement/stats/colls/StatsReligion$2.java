/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATFakeRace;
/*     */ import settlement.stats.util.StatHoverer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends STATFakeRace
/*     */ {
/*     */   null(String $anonymous0, StatsInit $anonymous1) {
/* 134 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected double getDD(Race r) {
/* 138 */     return StatsReligion.this.opposition();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, HCLASS cl, Race type) {
/* 144 */     GBox b = (GBox)text;
/* 145 */     StatHoverer.hover(text, (STAT)this);
/* 146 */     b.sep();
/* 147 */     for (int x = 0; x < StatsReligion.this.ALL.size(); x++) {
/* 148 */       b.tab(1 + x * 2);
/* 149 */       b.add(((StatsReligion.StatReligion)StatsReligion.this.ALL.get(x)).religion.icon.small);
/*     */     } 
/*     */     
/* 152 */     b.NL(4);
/* 153 */     for (int y = 0; y < StatsReligion.this.ALL.size(); y++) {
/* 154 */       StatsReligion.StatReligion r = (StatsReligion.StatReligion)StatsReligion.this.ALL.get(y);
/* 155 */       b.add(r.religion.icon.small);
/* 156 */       for (int i = 0; i < StatsReligion.this.ALL.size(); i++) {
/* 157 */         b.tab(1 + i * 2);
/* 158 */         if (r.opposition((StatsReligion.StatReligion)StatsReligion.this.ALL.get(i)) > 0.0D) {
/* 159 */           b.add((SPRITE)GFORMAT.f(b.text(), r.opposition((StatsReligion.StatReligion)StatsReligion.this.ALL.get(i))).errorify());
/*     */         } else {
/* 161 */           b.add((SPRITE)GFORMAT.f(b.text(), r.opposition((StatsReligion.StatReligion)StatsReligion.this.ALL.get(i))).normalify());
/*     */         } 
/* 163 */       }  b.NL(2);
/*     */     } 
/*     */     
/* 166 */     b.sep();
/*     */     
/* 168 */     StatHoverer.hover(text, (STAT)this, cl, type);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsReligion$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */