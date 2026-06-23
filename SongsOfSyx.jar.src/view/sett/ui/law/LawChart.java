/*     */ package view.sett.ui.law;
/*     */ import game.time.TIME;
/*     */ import init.settings.S;
/*     */ import init.type.CRIMES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.law.StatCrime;
/*     */ import settlement.stats.law.StatPunishment;
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
/*     */ final class LawChart extends GuiSection {
/*  25 */   final GuiSection pop = new GuiSection();
/*     */   
/*  27 */   private static CharSequence ¤¤arrests = "Arrests";
/*     */   static {
/*  29 */     D.ts(LawChart.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public LawChart(int sw, final HCLASS cl, final Selector race) {
/*  34 */     if ((S.get()).developer) {
/*  35 */       for (StatPunishment t : (STATS.LAW()).punishments) {
/*  36 */         this.pop.add((RENDEROBJ)new GButt.Glow(t.punish.name)
/*     */             {
/*     */               protected void clickA() {
/*  39 */                 STATS.LAW().punish((CRIMES.CRIME)CRIMES.all(cl).rnd(), cl, race.getRace(), t.punish);
/*     */               }
/*  41 */             }this.pop.body().x1(), this.pop.body().y2());
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  50 */     GStaples chart = new GStaples(32)
/*     */       {
/*     */         
/*     */         protected void renderExtra(SPRITE_RENDERER r, COLOR color, int stapleI, boolean hovered, double value, int x1, int x2, int y1, int y2)
/*     */         {
/*  55 */           x1++;
/*  56 */           x2--;
/*  57 */           int ii = 32 - stapleI - 1;
/*  58 */           double tot = getValue(stapleI);
/*  59 */           ColorImp c = ColorImp.TMP;
/*  60 */           double dy1 = y1;
/*  61 */           double dy2 = y1;
/*  62 */           double dy = (y2 - y1);
/*  63 */           if (dy <= 0.0D) {
/*     */             return;
/*     */           }
/*  66 */           double d = 0.0D;
/*  67 */           for (StatCrime cr : (STATS.LAW()).crimes) {
/*  68 */             d += cr.caught().history(HCLASS_RACE.clP(race.getRace(), cl)).get(ii);
/*     */           }
/*  70 */           dy2 += d / tot;
/*  71 */           c.set((COLOR)COLOR.UNIQUE.getC(0));
/*  72 */           if (hovered) {
/*  73 */             c.shadeSelf(1.2D);
/*     */           }
/*  75 */           c.render(r, x1, x2, (int)dy1, (int)dy2);
/*  76 */           dy1 = dy2;
/*     */           
/*  78 */           for (StatPunishment p : (STATS.LAW()).punishments) {
/*  79 */             double d1 = dy * p.success().history(HCLASS_RACE.clP(race.getRace(), cl)).get(ii) / tot;
/*  80 */             dy2 += d1;
/*  81 */             c.set((COLOR)COLOR.UNIQUE.getC(p.punish.index() + 1));
/*  82 */             if (hovered) {
/*  83 */               c.shadeSelf(1.2D);
/*     */             }
/*  85 */             c.render(r, x1, x2, (int)dy1, (int)dy2);
/*  86 */             dy1 = dy2;
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void hover(GBox box, int stapleI) {
/*  93 */           int i = 32 - stapleI - 1;
/*     */           
/*  95 */           box.textLL((CharSequence)DicTime.setAgo((Str)box.text(), (i * TIME.secondsPerDay())));
/*  96 */           box.NL();
/*  97 */           HCLASS_RACE cc = HCLASS_RACE.clP(race.getRace(), cl);
/*     */           
/*  99 */           int arrests = 0;
/* 100 */           for (StatCrime c : (STATS.LAW()).crimes) {
/* 101 */             arrests += c.caught().history(cc).get(i);
/*     */           }
/* 103 */           box.textLL(LawChart.¤¤arrests);
/* 104 */           box.tab(6);
/* 105 */           box.add((SPRITE)GFORMAT.i(box.text(), arrests));
/* 106 */           box.NL(8);
/*     */           
/* 108 */           for (StatPunishment p : (STATS.LAW()).punishments) {
/* 109 */             box.textLL(p.punish.names);
/* 110 */             box.tab(6);
/* 111 */             box.add((SPRITE)GFORMAT.i(box.text(), p.success().history(cc).get(i)));
/* 112 */             box.NL();
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/* 120 */           int i = 32 - stapleI - 1;
/* 121 */           HCLASS_RACE cc = HCLASS_RACE.clP(race.getRace(), cl);
/* 122 */           int arrests = 0;
/* 123 */           for (StatCrime c : (STATS.LAW()).crimes) {
/* 124 */             arrests += c.caught().history(cc).get(i);
/*     */           }
/*     */           
/* 127 */           for (StatPunishment p : (STATS.LAW()).punishments) {
/* 128 */             arrests += p.success().history(cc).get(i);
/*     */           }
/*     */           
/* 131 */           return arrests;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 138 */     chart.normalize(true);
/* 139 */     chart.body().setDim((32 * sw), 80.0D);
/* 140 */     add((RENDEROBJ)chart, body().x1() - 40, body().y2() + 4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 147 */     if ((S.get()).developer)
/* 148 */       (VIEW.inters()).popup.show((RENDEROBJ)this.pop, (CLICKABLE)this); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\law\LawChart.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */