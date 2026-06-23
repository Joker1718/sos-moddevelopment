/*     */ package view.sett.ui.law;
/*     */ import game.time.TIME;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.CRIMES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.law.StatCrime;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.DicTime;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class CrimeChart extends GuiSection {
/*  25 */   final GuiSection pop = new GuiSection();
/*     */ 
/*     */ 
/*     */   
/*     */   public CrimeChart(int sw, final HCLASS cl, final Selector race) {
/*  30 */     for (StatCrime t : (STATS.LAW()).crimes) {
/*  31 */       this.pop.add((RENDEROBJ)new GButt.Glow("commit: " + String.valueOf(t.crime.name))
/*     */           {
/*     */             protected void clickA() {
/*  34 */               t.commit(HCLASS_RACE.clP(race.getRace(), cl), 1);
/*     */             }
/*  36 */           }this.pop.body().x1(), this.pop.body().y2());
/*  37 */       this.pop.addRightC(20, (RENDEROBJ)new GButt.Glow("arrest: " + String.valueOf(t.crime.name))
/*     */           {
/*     */             protected void clickA() {
/*  40 */               t.catchh(race.getRace());
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  48 */     GStaples chart = new GStaples(32)
/*     */       {
/*     */         
/*     */         protected void renderExtra(SPRITE_RENDERER r, COLOR color, int stapleI, boolean hovered, double value, int x1, int x2, int y1, int y2)
/*     */         {
/*  53 */           x1++;
/*  54 */           x2--;
/*  55 */           int ii = 32 - stapleI - 1;
/*  56 */           double tot = 0.0D;
/*  57 */           for (StatCrime statCrime : (STATS.LAW()).crimes)
/*  58 */             tot += statCrime.occurence().history(HCLASS_RACE.clP(race.getRace(), cl)).get(ii); 
/*  59 */           ColorImp c = ColorImp.TMP;
/*  60 */           double dy1 = y1;
/*  61 */           double dy2 = y1;
/*  62 */           double dy = (y2 - y1);
/*  63 */           if (dy <= 0.0D) {
/*     */             return;
/*     */           }
/*  66 */           for (StatCrime cr : (STATS.LAW()).crimes) {
/*  67 */             double d = dy * cr.occurence().history(HCLASS_RACE.clP(race.getRace(), cl)).get(ii) / tot;
/*  68 */             dy2 += d;
/*  69 */             c.set((COLOR)COLOR.UNIQUE.getC(cr.crime.index()));
/*  70 */             if (hovered) {
/*  71 */               c.shadeSelf(1.2D);
/*     */             }
/*  73 */             c.render(r, x1, x2, (int)dy1, (int)dy2);
/*  74 */             dy1 = dy2;
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         protected void hover(GBox box, int stapleI) {
/*  80 */           int ii = 32 - stapleI - 1;
/*     */           
/*  82 */           box.textL((CharSequence)DicTime.setAgo((Str)box.text(), (ii * TIME.secondsPerDay())));
/*  83 */           box.NL(4);
/*     */           
/*  85 */           for (CRIMES.CRIME c : CRIMES.all(cl)) {
/*  86 */             box.add((SPRITE)(SPRITES.icons()).s.circle, (COLOR)COLOR.UNIQUE.getC(c.index()));
/*  87 */             box.text(c.names);
/*  88 */             box.tab(6);
/*  89 */             box.add((SPRITE)GFORMAT.i(box.text(), ((StatCrime)(STATS.LAW()).crimes.get(c.index())).occurence().history(HCLASS_RACE.clP(race.getRace(), cl)).get(ii)));
/*  90 */             box.NL();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/*  96 */           int ii = 32 - stapleI - 1;
/*  97 */           int am = 0;
/*  98 */           for (StatCrime c : (STATS.LAW()).crimes)
/*  99 */             am += c.occurence().history(HCLASS_RACE.clP(race.getRace(), cl)).get(ii); 
/* 100 */           return am;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void setColor(ColorImp c, int stapleI, double value) {
/* 105 */           c.set(COLOR.YELLOW100).saturateSelf(0.5D);
/*     */         }
/*     */       };
/*     */     
/* 109 */     chart.body().setWidth((32 * sw));
/* 110 */     chart.body().setHeight(80.0D);
/*     */ 
/*     */     
/* 113 */     add((RENDEROBJ)chart, body().x1() - 40, body().y2() + 4);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 118 */     if ((S.get()).developer)
/* 119 */       (VIEW.inters()).popup.show((RENDEROBJ)this.pop, (CLICKABLE)this); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\law\CrimeChart.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */