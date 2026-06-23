/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import world.army.AD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 132 */     GFORMAT.iIncr(text, (POP.tot(cl, (Race)CatPopulation.this.race.get()) - (STATS.POP()).POP.data(cl).get(CatPopulation.this.race.get()) + POP.incoming(cl, (Race)CatPopulation.this.race.get())));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/* 139 */     b.title(CatPopulation.¤¤others);
/* 140 */     b.text(CatPopulation.¤¤othersD);
/* 141 */     b.sep();
/*     */     
/* 143 */     b.add((SPRITE)(UI.icons()).s.arrow_right);
/* 144 */     b.textLL(Dic.¤¤Next);
/* 145 */     b.tab(6);
/* 146 */     b.add((SPRITE)GFORMAT.i(b.text(), POP.incoming(cl, (Race)CatPopulation.this.race.get())));
/* 147 */     b.NL();
/* 148 */     b.text(CatPopulation.this.desc);
/* 149 */     b.NL(4);
/*     */     
/* 151 */     for (HTYPE t : HTYPES.ALL()) {
/* 152 */       if ((t.parent()).CLASS != t.CLASS && t.parentClass() == cl) {
/* 153 */         add(t, b);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 159 */     if (cl == HCLASSES.CITIZEN()) {
/*     */       
/* 161 */       add(AD.cityDivs().total((Race)CatPopulation.this.race.get()), HTYPES.SOLDIER(), CatPopulation.¤¤Soldiers, b);
/* 162 */       add(STATS.LAW().criminals(HCLASSES.CITIZEN(), (Race)CatPopulation.this.race.get()), HTYPES.PRISONER(), (HTYPES.PRISONER()).desc, b);
/* 163 */       add(HTYPES.RIOTER(), b);
/* 164 */       add(HTYPES.DERANGED(), b);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void add(HTYPE t, GBox b) {
/* 171 */     add(STATS.POP().pop((Race)CatPopulation.this.race.get(), t), t, t.desc, b);
/*     */   }
/*     */   
/*     */   private void add(int am, HTYPE t, CharSequence desc, GBox b) {
/* 175 */     b.add(t.icon);
/* 176 */     b.textLL(t.names);
/* 177 */     b.tab(6);
/* 178 */     b.add((SPRITE)GFORMAT.i(b.text(), am));
/* 179 */     b.NL();
/* 180 */     b.text(desc);
/* 181 */     b.NL(4);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatPopulation$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */