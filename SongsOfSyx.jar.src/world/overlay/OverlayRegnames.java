/*     */ package world.overlay;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FBanner;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.IntChecker;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.BOOLEAN;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OverlayRegnames
/*     */   extends WorldOverlays.Overlay
/*     */ {
/*  30 */   private final IntChecker check = new IntChecker(1023);
/*  31 */   private final Text text = new Text((UI.FONT()).H1, 24);
/*     */   
/*  33 */   public final BOOLEAN.BOOLEANImp active = new BOOLEAN.BOOLEANImp(true);
/*     */   
/*     */   public OverlayRegnames() {
/*  36 */     this.text.setMultipleLines(false);
/*     */   }
/*     */   
/*     */   public void exclude(Region r) {
/*  40 */     this.check.isSetAndSet(r.index());
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAbove(Renderer r, ShadowBatch s, RenderData data) {
/*  45 */     if (!this.active.is()) {
/*     */       return;
/*     */     }
/*  48 */     for (Region reg : WORLD.REGIONS().active()) {
/*  49 */       if (!this.check.isSet(reg.index())) {
/*  50 */         for (DIR d : DIR.NORTHO) {
/*  51 */           if (data.tBounds().holdsPoint((reg.cx() + d.x() * 5), (reg.cy() + d.y() * 5))) {
/*  52 */             render(reg, r, s, data);
/*     */ 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  62 */     this.check.init();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Region reg, Renderer r, ShadowBatch s, RenderData data) {
/*  68 */     if (r.getZoomout() >= 2) {
/*  69 */       this.text.setFont((UI.FONT()).S);
/*  70 */       this.text.setScale(4.0D);
/*     */     } else {
/*  72 */       this.text.setFont((UI.FONT()).H1);
/*  73 */       this.text.setScale(1.0D);
/*     */     } 
/*     */     
/*  76 */     this.text.clear().add((CharSequence)reg.info.name());
/*  77 */     this.text.adjustWidth();
/*  78 */     this.text.setMaxWidth(384);
/*     */     
/*  80 */     int cx = reg.info.cx() * 64 + 32;
/*  81 */     int cy = reg.info.cy() * 64 + 32;
/*     */     
/*  83 */     int dy = (int)(64.0D * (1.2D + (reg.capitol() ? 0.5D : 0.0D)));
/*     */     
/*  85 */     int x1 = cx - this.text.width() / 2;
/*  86 */     int y1 = 8 + cy + dy;
/*     */     
/*  88 */     if (canRender(reg, (DIMENSION)this.text, x1, y1)) {
/*  89 */       render(reg, x1, y1, r, s, data);
/*     */     } else {
/*  91 */       int yy1 = cy - this.text.height() - dy;
/*  92 */       if (canRender(reg, (DIMENSION)this.text, x1, yy1)) {
/*  93 */         render(reg, x1, yy1, r, s, data);
/*     */       } else {
/*  95 */         render(reg, x1, y1, r, s, data);
/*     */       } 
/*     */     } 
/*     */     
/*  99 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean canRender(Region reg, DIMENSION dim, int x1, int y1) {
/* 104 */     int y2 = y1 + dim.height();
/* 105 */     int x2 = x1 + dim.width();
/* 106 */     if (is(reg, x1, y1) && is(reg, x2, y1) && is(reg, x2, y2) && is(reg, x1, y2)) {
/* 107 */       return true;
/*     */     }
/* 109 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(Region reg, int x1, int y1, Renderer r, ShadowBatch s, RenderData data) {
/* 114 */     s.setHard().setDistance2Ground(0.0D).setHeight(0);
/* 115 */     x1 = data.transformGX(x1);
/* 116 */     y1 = data.transformGY(y1);
/*     */     
/* 118 */     int ox = x1;
/* 119 */     int oy = y1;
/*     */     
/* 121 */     int M = 8;
/* 122 */     int H = this.text.height();
/*     */     
/* 124 */     if (reg.faction() == null) {
/* 125 */       COLOR.WHITE25.render((SPRITE_RENDERER)s, x1 - M, x1 + this.text.width() + M + H + M, y1 - M, y1 + H + M);
/* 126 */       COLOR.WHITE65.bind();
/* 127 */       renderText(r, x1, y1);
/* 128 */       COLOR.unbind();
/* 129 */       (DIP.WAR()).icon.render((SPRITE_RENDERER)r, x1 + this.text.width() + M, x1 + this.text.width() + M + H, y1, y1 + H);
/* 130 */     } else if (reg.faction() == FACTIONS.player()) {
/*     */       
/* 132 */       COLOR.WHITE25.render((SPRITE_RENDERER)s, x1 - M, x1 + this.text.width() + M + H + M, y1 - M, y1 + H + M);
/* 133 */       if (reg.capitol()) {
/* 134 */         (UI.icons()).s.crown.render((SPRITE_RENDERER)r, x1, x1 + H, y1, y1 + H);
/* 135 */         x1 += H + M;
/*     */       } 
/* 137 */       reg.faction().banner().colorBGBright().bind();
/* 138 */       renderText(r, x1, y1);
/* 139 */       if (!reg.capitol()) {
/* 140 */         double loy = (RD.RACES()).loyaltyAll.getD(reg);
/*     */         
/* 142 */         SPRITE sp = (UI.icons()).s.faces[(int)Math.round(loy * ((UI.icons()).s.faces.length - 1))];
/*     */         
/* 144 */         GCOLOR.UI().badToGood(ColorImp.TMP, loy);
/* 145 */         ColorImp.TMP.bind();
/* 146 */         sp.render((SPRITE_RENDERER)r, x1 + this.text.width(), x1 + this.text.width() + H, y1, y1 + H);
/* 147 */         COLOR.unbind();
/*     */       } 
/*     */     } else {
/* 150 */       COLOR.WHITE25.render((SPRITE_RENDERER)s, x1 - M, x1 + this.text.width() + M + H + M + H, y1 - M, y1 + this.text.height() + M);
/* 151 */       if (reg.capitol()) {
/* 152 */         (UI.icons()).s.crown.render((SPRITE_RENDERER)r, x1, x1 + H, y1, y1 + H);
/*     */       } else {
/* 154 */         FBanner.render((SPRITE_RENDERER)r, reg.faction(), x1, x1 + H, y1, y1 + H);
/*     */       } 
/* 156 */       x1 += H + M;
/* 157 */       reg.faction().banner().colorBGBright().bind();
/* 158 */       renderText(r, x1, y1);
/*     */       
/* 160 */       x1 += this.text.width() + M;
/* 161 */       COLOR.unbind();
/* 162 */       (DIP.get((Faction)FACTIONS.player(), reg.faction())).icon.render((SPRITE_RENDERER)r, x1, x1 + H, y1, y1 + H);
/*     */     } 
/*     */     
/* 165 */     if (reg.besieged()) {
/* 166 */       (GCOLOR.MAP()).SOSO.bind();
/* 167 */       (UI.icons()).s.degrade.render((SPRITE_RENDERER)r, ox - H / 2, ox - H / 2 + H, oy - H / 2, oy - H / 2 + H);
/* 168 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderText(Renderer r, int x1, int y1) {
/* 217 */     this.text.render((SPRITE_RENDERER)r, x1, y1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean is(Region reg, int x, int y) {
/* 223 */     x >>= 6;
/* 224 */     y >>= 6;
/* 225 */     return (WORLD.REGIONS()).map.is(x, y, reg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderBelow(Renderer r, ShadowBatch s, RenderData data) {
/* 231 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\OverlayRegnames.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */