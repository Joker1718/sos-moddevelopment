/*     */ package settlement.overlay;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.info.INFO;
/*     */ import util.rendering.RenderData;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Addable
/*     */   extends INFO
/*     */ {
/*  25 */   static ArrayListGrower<Addable> ALL = new ArrayListGrower();
/*     */ 
/*     */   
/*     */   static final int iSize = 48;
/*     */ 
/*     */   
/*     */   static final int iOff = 8;
/*     */ 
/*     */   
/*     */   boolean added = false;
/*     */   
/*     */   final boolean above;
/*     */   
/*     */   final boolean under;
/*     */   
/*     */   public final String key;
/*     */   
/*     */   protected boolean exclusive = false;
/*     */   
/*     */   public final SPRITE icon;
/*     */ 
/*     */   
/*     */   public Addable(SPRITE icon, String key, CharSequence name, CharSequence desc) {
/*  48 */     this(icon, key, name, desc, false, true);
/*     */   }
/*     */   
/*     */   public Addable(SPRITE icon, String key, CharSequence name, CharSequence desc, boolean underling, boolean above) {
/*  52 */     super(name, desc);
/*  53 */     ALL.add(this);
/*  54 */     this.under = underling;
/*  55 */     this.above = above;
/*  56 */     this.key = key;
/*  57 */     this.icon = icon;
/*     */   }
/*     */   
/*     */   public Addable(boolean underling, boolean above) {
/*  61 */     this(null, null, null, null, underling, above);
/*     */   }
/*     */   
/*     */   public void add() {
/*  65 */     (SETT.OVERLAY()).added = true;
/*  66 */     this.added = true;
/*     */   }
/*     */   
/*     */   public boolean added() {
/*  70 */     return this.added;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initBelow(RenderData data) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void finishBelow() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void initAbove(RenderData data) {}
/*     */ 
/*     */   
/*     */   public void finishAbove() {}
/*     */ 
/*     */   
/*     */   public boolean render(Renderer r, RenderData.RenderIterator it) {
/*  90 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderBelow(Renderer r, RenderData.RenderIterator it) {}
/*     */ 
/*     */   
/*     */   public static void renderUnder(double v, Renderer r, RenderData.RenderIterator it) {
/*  98 */     renderUnder(v, r, it, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean renderAbove(double v, Renderer r, RenderData.RenderIterator it, boolean pluses) {
/*     */     ColorImp colorImp;
/* 104 */     COLOR c = COLOR.WHITE05;
/*     */     
/* 106 */     if (v >= 0.0D) {
/* 107 */       colorImp = ColorImp.TMP.interpolate(COLOR.WHITE05, (GCOLOR.MAP()).OVERLAY_GOOD, v);
/*     */     } else {
/* 109 */       colorImp = ColorImp.TMP.interpolate(COLOR.WHITE05, (GCOLOR.MAP()).OVERLAY_BAD, -v);
/*     */     } 
/* 111 */     if (!renderAbove((COLOR)colorImp, r, it)) {
/* 112 */       return false;
/*     */     }
/* 114 */     if (pluses && VIEW.s().getWindow().zoomout() <= 1) {
/* 115 */       int am = (int)Math.round(v * 4.0D);
/* 116 */       for (int i = 0; i < am; i++) {
/* 117 */         (SPRITES.icons()).s.plus.renderScaled((SPRITE_RENDERER)r, it.x() + 16 * i % 2, it.y() + 16 + i / 2 * 16, 2);
/*     */       }
/*     */     } 
/* 120 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderUnder(double v, Renderer r, RenderData.RenderIterator it, boolean pluses) {
/*     */     ColorImp colorImp;
/* 126 */     COLOR c = COLOR.WHITE05;
/*     */     
/* 128 */     if (v >= 0.0D) {
/* 129 */       colorImp = ColorImp.TMP.interpolate(COLOR.WHITE05, (GCOLOR.MAP()).OVERLAY_GOOD, v);
/*     */     } else {
/* 131 */       colorImp = ColorImp.TMP.interpolate(COLOR.WHITE05, (GCOLOR.MAP()).OVERLAY_BAD, -v);
/*     */     } 
/* 133 */     if (!renderUnder((COLOR)colorImp, r, it)) {
/*     */       return;
/*     */     }
/* 136 */     if (pluses && VIEW.s().getWindow().zoomout() <= 1) {
/* 137 */       int am = (int)Math.round(v * 4.0D);
/* 138 */       for (int i = 0; i < am; i++) {
/* 139 */         (SPRITES.icons()).s.plus.renderScaled((SPRITE_RENDERER)r, it.x() + 16 * i % 2, it.y() + 16 + i / 2 * 16, 2);
/*     */       }
/*     */     } 
/* 142 */     it.hiddenSet();
/*     */   }
/*     */   
/*     */   public static void renderPluses(double v, Renderer r, RenderData.RenderIterator it) {
/* 146 */     if (VIEW.s().getWindow().zoomout() <= 1) {
/* 147 */       int am = (int)Math.round(v * 4.0D);
/* 148 */       for (int i = 0; i < am; i++) {
/* 149 */         (SPRITES.icons()).s.plus.renderScaled((SPRITE_RENDERER)r, it.x() + 16 * i % 2, it.y() + 16 + i / 2 * 16, 2);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void renderColor(double v, Renderer r, RenderData.RenderIterator it, boolean pluses) {
/*     */     ColorImp colorImp;
/* 156 */     COLOR c = COLOR.WHITE05;
/*     */     
/* 158 */     if (v >= 0.0D) {
/* 159 */       colorImp = ColorImp.TMP.interpolate(COLOR.WHITE05, (GCOLOR.MAP()).OVERLAY_GOOD, v);
/*     */     } else {
/* 161 */       colorImp = ColorImp.TMP.interpolate(COLOR.WHITE05, (GCOLOR.MAP()).OVERLAY_BAD, -v);
/*     */     } 
/* 163 */     colorImp.bind();
/* 164 */     (SPRITES.cons()).BIG.filled.render((SPRITE_RENDERER)r, 15, it.x(), it.y());
/* 165 */     if (pluses && VIEW.s().getWindow().zoomout() <= 1) {
/* 166 */       int am = (int)Math.round(v * 4.0D);
/* 167 */       for (int i = 0; i < am; i++) {
/* 168 */         (SPRITES.icons()).s.plus.renderScaled((SPRITE_RENDERER)r, it.x() + 16 * i % 2, it.y() + 16 + i / 2 * 16, 2);
/*     */       }
/*     */     } 
/* 171 */     it.hiddenSet();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean renderUnder(COLOR c, Renderer r, RenderData.RenderIterator it) {
/* 176 */     if (VIEW.s().getWindow().zoomout() >= 3 && SETT.TERRAIN().get(it.tile()).miniDepth() > 0) {
/* 177 */       return false;
/*     */     }
/* 179 */     if ((SETT.ROOMS()).placement.embryo.is(it.tile()))
/* 180 */       return false; 
/* 181 */     c.bind();
/*     */     
/* 183 */     int m = 15;
/*     */     
/* 185 */     Floors.Floor f = (Floors.Floor)(SETT.FLOOR()).getter.get(it.tile());
/*     */     
/* 187 */     if (f != null) {
/* 188 */       COLOR.unbind();
/* 189 */       SETT.FLOOR().renderSimple((SPRITE_RENDERER)r, it, f);
/* 190 */       c.bind();
/* 191 */       m = rMask(it);
/* 192 */       (SPRITES.cons()).BIG.filled_striped.render((SPRITE_RENDERER)r, m, it.x(), it.y());
/* 193 */     } else if ((SETT.ROOMS()).map.is(it.tile())) {
/* 194 */       m = rMask(it);
/* 195 */       (SPRITES.cons()).BIG.filled_striped.render((SPRITE_RENDERER)r, m, it.x(), it.y());
/*     */     } else {
/*     */       
/* 198 */       (SPRITES.cons()).BIG.filled.render((SPRITE_RENDERER)r, m, it.x(), it.y());
/*     */     } 
/*     */     
/* 201 */     it.hiddenSet();
/* 202 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean renderAbove(COLOR c, Renderer r, RenderData.RenderIterator it) {
/* 207 */     if ((SETT.ROOMS()).placement.embryo.is(it.tile())) {
/* 208 */       return false;
/*     */     }
/* 210 */     Terrain.TerrainTile tt = SETT.TERRAIN().get(it.tile());
/*     */     
/* 212 */     if (tt != (SETT.TERRAIN()).NADA && !(tt instanceof settlement.tilemap.terrain.TBuilding.Ceiling)) {
/*     */       
/* 214 */       c.bind();
/*     */ 
/*     */       
/* 217 */       (SPRITES.cons()).BIG.filled_striped.render((SPRITE_RENDERER)r, 0, it.x(), it.y());
/* 218 */       return true;
/*     */     } 
/* 220 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int rMask(RenderData.RenderIterator it) {
/* 225 */     int m = 0;
/* 226 */     for (DIR d : DIR.ORTHO) {
/* 227 */       int tx = it.tx() + d.x();
/* 228 */       int ty = it.ty() + d.y();
/*     */       
/* 230 */       if ((SETT.FLOOR()).getter.get(tx, ty) != null || (SETT.ROOMS()).map.is(tx, ty)) {
/* 231 */         m |= d.mask();
/*     */       }
/*     */     } 
/* 234 */     return m;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\overlay\Addable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */