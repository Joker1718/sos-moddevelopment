/*     */ package view.ui.div;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import init.constant.Config;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.Comparator;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.colors.GCOLOR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class UIDiv
/*     */ {
/*  26 */   final int WIDTH = 58;
/*  27 */   final int HEIGHT = 78;
/*     */   
/*  29 */   public final UIDivCardSett settCivic = new UIDivCardSett(this);
/*  30 */   public final UIDivCardBasic normal = new UIDivCardBasic(this);
/*  31 */   public final UIDivCardWorld world = new UIDivCardWorld(this);
/*  32 */   public final UIDivCardBattle battle = new UIDivCardBattle(this);
/*     */   
/*  34 */   private final ArrayList<EquipBattle> equips = new ArrayList(STATS.EQUIP().BATTLE_ALL().size());
/*  35 */   private final Rec body = new Rec();
/*     */   
/*     */   private final Comp comp;
/*     */   
/*     */   private final COLOR[] cPower;
/*     */   
/*     */   private static class Comp
/*     */     implements Comparator<EquipBattle>
/*     */   {
/*     */     DIV_SPEC d;
/*     */     
/*     */     public int compare(EquipBattle o1, EquipBattle o2) {
/*  47 */       return (o1.sprites[(this.d.race()).index]).z - (o2.sprites[(this.d.race()).index]).z;
/*     */     }
/*     */   }
/*     */   
/*     */   public UIDiv()
/*     */   {
/*  53 */     this.comp = new Comp();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 124 */     this
/*     */ 
/*     */       
/* 127 */       .cPower = new COLOR[] { (COLOR)(new ColorImp(114, 84, 33)).shade(0.7D), (COLOR)(new ColorImp(114, 114, 114)).shade(0.7D), (COLOR)(new ColorImp(114, 114, 33)).shade(0.7D) };
/*     */   }
/*     */   
/*     */   public void renderPower(int x1, int y1, SPRITE_RENDERER r, double l) {
/* 131 */     l /= 5.0D * (Config.battle()).MEN_PER_DIVISION;
/*     */     
/* 133 */     int ci = CLAMP.i((int)(l * 3.0D), 0, 2);
/* 134 */     l -= ci / 3.0D;
/* 135 */     int am = (int)(1.0D + l * 5.0D);
/* 136 */     am = CLAMP.i(am, 1, 6);
/*     */ 
/*     */ 
/*     */     
/* 140 */     OPACITY.O50.bind();
/* 141 */     COLOR.BLACK.render(r, x1, x1 + 10, y1, y1 + am * 8 + 4);
/* 142 */     OPACITY.unbind();
/* 143 */     y1 += 2;
/* 144 */     x1++;
/* 145 */     this.cPower[ci].bind();
/* 146 */     for (int i = 0; i < am; i++) {
/* 147 */       (UI.icons()).s.chevron(DIR.N).render(r, x1, y1 + i * 8);
/*     */     }
/* 149 */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   public void renderBasics(SPRITE_RENDERER r, int x1, int y1, int scale, DIV_SPEC d) {
/*     */     if (d == null)
/*     */       return; 
/*     */     this.body.set(x1, (x1 + 58 * scale), y1, (y1 + 78 * scale));
/*     */     int cx = this.body.cX();
/*     */     (GAME.ARMIES()).banners.get(d.bannerI()).renderCX(r, cx - 12 * scale, y1 + 4 * scale, scale);
/*     */     (d.race().appearance()).icon.renderCX(r, cx, this.body.y1() + 18 * scale, scale);
/*     */     this.equips.clearSloppy();
/*     */     for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/*     */       if (d.equip(e) > 0.0D)
/*     */         this.equips.add(e); 
/*     */     } 
/*     */     this.comp.d = d;
/*     */     this.equips.sort(this.comp);
/*     */     for (EquipBattle e : this.equips) {
/*     */       EquipBattle.DivSprite s = e.sprites[d.race().index()];
/*     */       OPACITY.O50.bind();
/*     */       COLOR.BLACK.bind();
/*     */       s.icon.renderCX(r, cx + s.ox * scale + 2 * scale, y1 + 54 * scale + s.oy * scale, scale);
/*     */       OPACITY.unbind();
/*     */       ColorImp.TMP.interpolate(s.cols, d.equip(e)).bind();
/*     */       s.icon.renderCX(r, cx + s.ox * scale, y1 + 52 * scale + s.oy * scale, scale);
/*     */     } 
/*     */     int k = 0;
/*     */     for (StatsBattle.StatTraining t : (STATS.BATTLE()).TRAINING_ALL) {
/*     */       double d1 = d.training(t);
/*     */       if (d1 > 0.0D) {
/*     */         int j = (int)(d1 * 3.0D);
/*     */         ColorImp.TMP.interpolate(t.room.divCols, d1).bind();
/*     */         for (int m = 0; m <= j; m++)
/*     */           t.room.divIcon.renderScaled(r, cx - 2 * scale + k * 12 * scale, y1 + 2 * scale + scale * m * 5, scale); 
/*     */         k++;
/*     */         if (k >= 2)
/*     */           break; 
/*     */       } 
/*     */     } 
/*     */     double ds = d.experience();
/*     */     int am = (int)(ds * 5.0D);
/*     */     (GCOLOR.T()).H1.bind();
/*     */     for (int i = 0; i < am; i++)
/*     */       (UI.icons()).s.smallSkull.renderCScaled(r, cx - 20 * scale, y1 + 30 * scale + scale * 6 * i, scale); 
/*     */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDiv.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */