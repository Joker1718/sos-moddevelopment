/*     */ package util.colors;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.ColorShifting;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ public final class GCOLOR_UI
/*     */ {
/*  14 */   private Json d = (new Json(PATHS.SPRITE_UI().getLikeHells("Colors.txt"))).json("UI");
/*     */   
/*  16 */   public final GColorUIModel NORMAL = new GColorUIModel((COLOR)new ColorImp(this.d, "NORMAL"));
/*  17 */   public final GColorUIModel BAD = new GColorUIModel((COLOR)new ColorImp(this.d, "BAD"));
/*  18 */   public final GColorUIModel GOOD = new GColorUIModel((COLOR)new ColorImp(this.d, "GOOD"));
/*  19 */   public final GColorUIModel NEUTRAL = new GColorUIModel((COLOR)new ColorImp(this.d, "NEUTRAL"));
/*  20 */   public final GColorUIModel GOOD2 = new GColorUIModel((COLOR)new ColorImp(this.d, "GOOD2"));
/*  21 */   public final GColorUIModel GREAT = new GColorUIModel((COLOR)new ColorImp(this.d, "GREAT"));
/*  22 */   public final GColorUIModel SOSO = new GColorUIModel((COLOR)new ColorImp(this.d, "SOSO"));
/*  23 */   private static final ColorImp tmp = new ColorImp();
/*  24 */   private final COLOR badShift = (COLOR)(new ColorShifting(bg(), (COLOR)new ColorImp(this.d, "BAD_SHIFT"))).setSpeed(1.0D);
/*  25 */   private final COLOR goodShift = (COLOR)(new ColorShifting(bg(), (COLOR)new ColorImp(this.d, "GOOD_SHIFT"))).setSpeed(1.0D);
/*     */   
/*  27 */   private final COLOR border = COLOR.WHITE35;
/*  28 */   private final COLOR borderB = (COLOR)this.border.shade(1.5D);
/*  29 */   private final COLOR borderD = (COLOR)this.border.shade(0.5D);
/*     */   
/*  31 */   public final COLOR panBG = COLOR.WHITE15;
/*     */   
/*     */   public final COLOR gold;
/*     */   
/*     */   GCOLOR_UI() {
/*  36 */     this.gold = (COLOR)new ColorImp(this.d, "GOLD");
/*     */   }
/*     */   
/*     */   public static class GColorUIModel {
/*     */     public final COLOR normal;
/*     */     public final COLOR hovered;
/*     */     public final COLOR selected;
/*     */     public final COLOR inactive;
/*     */     
/*     */     private GColorUIModel(COLOR color) {
/*  46 */       this.inactive = (COLOR)color.shade(0.55D);
/*  47 */       this.normal = (COLOR)color.shade(0.8D);
/*  48 */       this.hovered = color;
/*  49 */       this.selected = (COLOR)color.shade(1.2D);
/*     */     }
/*     */     
/*     */     public COLOR get(boolean isActive, boolean isSelected, boolean isHovered) {
/*  53 */       if (!isActive)
/*  54 */         return this.inactive; 
/*  55 */       if (isHovered)
/*  56 */         return this.hovered; 
/*  57 */       if (isSelected)
/*  58 */         return this.selected; 
/*  59 */       return this.normal;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public COLOR border() {
/*  65 */     return COLOR.WHITE35;
/*     */   }
/*     */   
/*     */   public COLOR bg() {
/*  69 */     return COLOR.WHITE10;
/*     */   }
/*     */   
/*     */   public COLOR bg(boolean isActive, boolean isSelected, boolean isHovered) {
/*  73 */     if (!isActive)
/*  74 */       return COLOR.WHITE10; 
/*  75 */     if (isSelected)
/*  76 */       return COLOR.WHITE30; 
/*  77 */     if (isHovered)
/*  78 */       return COLOR.WHITE25; 
/*  79 */     return COLOR.WHITE15;
/*     */   }
/*     */ 
/*     */   
/*     */   public static COLOR color(COLOR color, boolean isActive, boolean isSelected, boolean isHovered) {
/*  84 */     if (isSelected)
/*  85 */       return (COLOR)tmp.set(color).add(36); 
/*  86 */     if (!isActive) {
/*  87 */       tmp.set(color).saturateSelf(0.7D);
/*  88 */       return (COLOR)tmp.add(-5);
/*     */     } 
/*  90 */     if (isHovered)
/*  91 */       return (COLOR)tmp.set(color).add(20); 
/*  92 */     return color;
/*     */   }
/*     */   
/*     */   public GColorUIModel bgHov() {
/*  96 */     return this.NORMAL;
/*     */   }
/*     */   
/*     */   public COLOR badFlash() {
/* 100 */     return this.badShift;
/*     */   }
/*     */   
/*     */   public COLOR goodFlash() {
/* 104 */     return this.goodShift;
/*     */   }
/*     */   
/*     */   public GColorUIModel BAD() {
/* 108 */     return this.BAD;
/*     */   }
/*     */   
/*     */   public GColorUIModel GOOD() {
/* 112 */     return this.GOOD;
/*     */   }
/*     */   
/*     */   public GColorUIModel SOSO() {
/* 116 */     return this.SOSO;
/*     */   }
/*     */ 
/*     */   
/*     */   public void badToGood(ColorImp imp, double v) {
/* 121 */     v = CLAMP.d(v, 0.0D, 1.0D);
/* 122 */     if (v < 0.5D) {
/* 123 */       imp.interpolate(this.BAD.normal, this.SOSO.normal, v * 2.0D);
/*     */     } else {
/* 125 */       imp.interpolate(this.SOSO.normal, this.GOOD.normal, (v - 0.5D) * 2.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void border(SPRITE_RENDERER ren, int X1, int X2, int Y1, int Y2) {
/* 131 */     this.borderB.render(ren, X1, X1 + 1, Y1, Y2);
/* 132 */     this.borderB.render(ren, X1, X2, Y1, Y1 + 1);
/* 133 */     this.borderD.render(ren, X2 - 1, X2, Y1 + 1, Y2);
/* 134 */     this.borderD.render(ren, X1 + 1, X2, Y2 - 1, Y2);
/* 135 */     this.border.render(ren, X1 + 1, X2 - 1, Y1 + 1, Y2 - 1);
/*     */   }
/*     */   
/*     */   public void border(SPRITE_RENDERER ren, RECTANGLE b, int m) {
/* 139 */     border(ren, b.x1() + m, b.x2() - m, b.y1() + m, b.y2() - m);
/*     */   }
/*     */   
/*     */   public void borderH(SPRITE_RENDERER ren, int X1, int X2, int Y1, int Y2) {
/* 143 */     this.borderB.render(ren, X1, X1 + 1, Y1, Y2);
/* 144 */     this.border.render(ren, X1 + 1, X1 + 2, Y1 + 1, Y2 - 1);
/* 145 */     this.borderD.render(ren, X1 + 2, X1 + 3, Y1 + 2, Y2 - 2);
/*     */     
/* 147 */     this.borderD.render(ren, X2 - 1, X2, Y1, Y2);
/* 148 */     this.border.render(ren, X2 - 2, X2 - 1, Y1 + 1, Y2 - 1);
/* 149 */     this.borderB.render(ren, X2 - 3, X2 - 2, Y1 + 2, Y2 - 2);
/*     */     
/* 151 */     this.borderB.render(ren, X1, X2, Y1, Y1 + 1);
/* 152 */     this.border.render(ren, X1 + 1, X2 - 1, Y1 + 1, Y1 + 2);
/* 153 */     this.borderD.render(ren, X1 + 2, X2 - 2, Y1 + 2, Y1 + 3);
/*     */     
/* 155 */     this.borderD.render(ren, X1, X2, Y2 - 1, Y2);
/* 156 */     this.border.render(ren, X1 + 1, X2 - 1, Y2 - 2, Y2 - 1);
/* 157 */     this.borderB.render(ren, X1 + 2, X2 - 2, Y2 - 3, Y2 - 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void borderH(SPRITE_RENDERER ren, RECTANGLE b, int m) {
/* 163 */     borderH(ren, b.x1() + m, b.x2() - m, b.y1() + m, b.y2() - m);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\colors\GCOLOR_UI.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */