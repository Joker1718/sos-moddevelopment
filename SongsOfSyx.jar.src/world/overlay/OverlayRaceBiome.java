/*     */ package world.overlay;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import util.colors.GCOLOR;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ class OverlayRaceBiome
/*     */   extends WorldOverlays.OverlayTileNormal
/*     */ {
/*  23 */   private static CharSequence ¤¤name = "¤Species Biome";
/*  24 */   private static CharSequence ¤¤desc = "¤Shows each region's base capacity for species."; Region compReg;
/*     */   static {
/*  26 */     D.ts(OverlayRaceBiome.class);
/*     */   }
/*     */   private final Comparator<RDRace> comp; private RDRace[] all;
/*     */   
/*     */   OverlayRaceBiome() {
/*  31 */     super(¤¤name, ¤¤desc, true, true);
/*     */ 
/*     */ 
/*     */     
/*  35 */     this.comp = new Comparator<RDRace>()
/*     */       {
/*     */         public int compare(RDRace o1, RDRace o2)
/*     */         {
/*  39 */           return Double.compare(o2.pop.biome.get(OverlayRaceBiome.this.compReg), o1.pop.biome.get(OverlayRaceBiome.this.compReg));
/*     */         }
/*     */       };
/*  42 */     this.all = new RDRace[(RD.RACES()).all.size()];
/*     */   }
/*     */   
/*     */   public void renderAbove(Renderer r, ShadowBatch s, RenderData data) {
/*  46 */     super.renderAbove(r, s, data);
/*     */     
/*  48 */     int scale = 1;
/*  49 */     int size = 64 * scale;
/*     */     
/*  51 */     for (Region reg : WORLD.REGIONS().active()) {
/*     */       
/*  53 */       for (DIR dir : DIR.NORTHO) {
/*  54 */         if (data.tBounds().holdsPoint((reg.cx() + dir.x() * 5), (reg.cy() + dir.y() * 5))) {
/*     */ 
/*     */           
/*  57 */           int am = (RD.RACES()).all.size();
/*  58 */           double tot = 0.0D;
/*     */           
/*  60 */           for (RDRace rr : (RD.RACES()).all) {
/*  61 */             tot += rr.pop.biome.get(reg);
/*  62 */             this.all[rr.index()] = rr;
/*     */           } 
/*     */           
/*  65 */           this.compReg = reg;
/*  66 */           Arrays.sort(this.all, this.comp);
/*     */           
/*  68 */           int x1 = data.transformGX(reg.cx() * 64 + 32 - am * size / 2);
/*  69 */           int y1 = data.transformGY((reg.cy() + 2) * 64); byte b; int i;
/*     */           RDRace[] arrayOfRDRace;
/*  71 */           for (i = (arrayOfRDRace = this.all).length, b = 0; b < i; ) { RDRace rr = arrayOfRDRace[b];
/*  72 */             double sc = (am * scale) * rr.pop.biome.get(reg) / tot;
/*  73 */             int ss = (int)Math.ceil(64.0D * sc);
/*  74 */             int d = (size - ss) / 2;
/*  75 */             COLOR.BLACK.bind();
/*  76 */             (rr.race.appearance()).icon.render((SPRITE_RENDERER)r, x1 + d + 8, x1 + d + ss + 8, y1 + d + 8, y1 + d + ss + 8);
/*  77 */             COLOR.unbind();
/*  78 */             (rr.race.appearance()).icon.render((SPRITE_RENDERER)r, x1 + d, x1 + d + ss, y1 + d, y1 + d + ss);
/*  79 */             x1 += ss;
/*     */             b++; }
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
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
/*     */   protected void renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/*  96 */     int m = 15;
/*  97 */     Region reg = (Region)(WORLD.REGIONS()).map.get(it.tile());
/*  98 */     if (WORLD.REGIONS().border().is(it.tile())) {
/*  99 */       m = 0;
/* 100 */       for (DIR d : DIR.ORTHO) {
/* 101 */         if (!WORLD.IN_BOUNDS(it.tx(), it.ty(), d) || reg == (WORLD.REGIONS()).map.get(it.tx(), it.ty(), d)) {
/* 102 */           m |= d.mask();
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 109 */     COLOR c = (reg == null || reg.faction() == null) ? (GCOLOR.MAP()).F_REBEL : (COLOR)reg.faction().banner().colorBG();
/* 110 */     c.bind();
/* 111 */     renderUnder(m, r, it);
/*     */   }
/*     */   
/*     */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\OverlayRaceBiome.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */