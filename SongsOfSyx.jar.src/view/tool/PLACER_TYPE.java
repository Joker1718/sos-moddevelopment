/*     */ package view.tool;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import snake2d.util.map.MAP_SETTER;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.text.D;
/*     */ import view.keyboard.KEYS;
/*     */ 
/*     */ public abstract class PLACER_TYPE
/*     */ {
/*     */   static {
/*  14 */     D.gInit(PLACER_TYPE.class);
/*     */   }
/*     */   
/*  17 */   public static final PLACER_TYPE SQUARE = new PLACER_TYPE(true, false, D.g("rectangle"))
/*     */     {
/*     */       Icon icon() {
/*  20 */         return (SPRITES.icons()).m.place_rec;
/*     */       }
/*     */ 
/*     */       
/*     */       void paint(int x1, int y1, int x2, int y2, int size, MAP_SETTER area) {
/*  25 */         int x11 = Math.min(x1, x2);
/*  26 */         int x22 = Math.max(x1, x2);
/*  27 */         int y11 = Math.min(y1, y2);
/*  28 */         int y22 = Math.max(y1, y2);
/*  29 */         for (int y = y11; y <= y22; y++) {
/*  30 */           for (int x = x11; x <= x22; x++)
/*  31 */             area.set(x, y); 
/*     */         } 
/*     */       }
/*     */     };
/*     */   
/*  36 */   public static final PLACER_TYPE SQUARE_HOLLOW = new PLACER_TYPE(true, true, D.g("hollow rectangle"))
/*     */     {
/*     */       Icon icon() {
/*  39 */         return (SPRITES.icons()).m.place_rec_hollow;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       void paint(int x1, int y1, int x2, int y2, int size, MAP_SETTER area) {
/*  45 */         int x11 = Math.min(x1, x2);
/*  46 */         int x22 = Math.max(x1, x2);
/*  47 */         int y11 = Math.min(y1, y2);
/*  48 */         int y22 = Math.max(y1, y2);
/*     */         
/*  50 */         while (size >= 0 && x11 <= x22 && y11 <= y22) {
/*  51 */           outline(x11, y11, x22, y22, area);
/*  52 */           x11++;
/*  53 */           x22--;
/*  54 */           y11++;
/*  55 */           y22--;
/*  56 */           size--;
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       void outline(int x1, int y1, int x2, int y2, MAP_SETTER area) {
/*  62 */         for (int y = y1; y <= y2; y++) {
/*  63 */           if (y == y1 || y == y2) {
/*  64 */             for (int x = x1; x <= x2; x++) {
/*  65 */               area.set(x, y);
/*     */             }
/*     */           } else {
/*  68 */             area.set(x1, y);
/*  69 */             area.set(x2, y);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     };
/*     */   
/*  75 */   public static final PLACER_TYPE BRUSH = new PLACER_TYPE(false, true, D.g("brush"))
/*     */     {
/*     */       Icon icon() {
/*  78 */         return (SPRITES.icons()).m.place_brush;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       void paint(int x1, int y1, int x2, int y2, int size, MAP_SETTER area) {
/*  84 */         size++;
/*  85 */         int min = size / 2;
/*     */         
/*  87 */         double s = size / 2.0D;
/*  88 */         double s2 = s * s;
/*  89 */         double d = ((size & 0x1) == 0) ? 0.5D : 0.0D;
/*     */         
/*  91 */         for (int dy = -min; dy <= min; dy++) {
/*  92 */           for (int dx = -min; dx <= min; dx++) {
/*  93 */             double dist = (dx + d) * (dx + d) + (dy + d) * (dy + d);
/*  94 */             if (dist <= s2) {
/*  95 */               area.set(x1 + dx, y1 + dy);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */     };
/*     */   
/* 102 */   public static final PLACER_TYPE LINE = new PLACER_TYPE(true, true, D.g("line"))
/*     */     {
/*     */       Icon icon() {
/* 105 */         return (SPRITES.icons()).m.place_line;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       void paint(int x1, int y1, int x2, int y2, int size, MAP_SETTER area) {
/* 111 */         if (x1 == x2 && y1 == y2) {
/* 112 */           area.set(x1, y1);
/*     */           
/*     */           return;
/*     */         } 
/* 116 */         int dx = x2 - x1;
/* 117 */         int dy = y2 - y1;
/* 118 */         dx = (dx < 0) ? -1 : ((dx > 0) ? 1 : 0);
/* 119 */         dy = (dy < 0) ? -1 : ((dy > 0) ? 1 : 0);
/* 120 */         boolean startX = (dy * dx >= 0);
/*     */         
/* 122 */         int newX = -dy;
/* 123 */         int newY = dx;
/* 124 */         dx = newX;
/* 125 */         dy = newY;
/*     */         
/* 127 */         int offX1 = 0;
/* 128 */         int offY1 = 0;
/*     */         
/*     */         int i;
/* 131 */         for (i = 1; i <= size / 2; i += 2) {
/* 132 */           if ((i & 0x1) == 1) {
/* 133 */             x1 -= dx;
/* 134 */             x2 -= dx;
/* 135 */             y1 -= dy;
/* 136 */             y2 -= dy;
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 142 */         for (i = 0; i <= size; i++) {
/*     */           
/* 144 */           drawLine(x1 + offX1, y1 + offY1, x2 + offX1, y2 + offY1, area, ((i & 0x1) == 0));
/* 145 */           if (startX) {
/* 146 */             offX1 += dx;
/*     */           } else {
/* 148 */             offY1 += dy;
/*     */           } 
/* 150 */           startX = !startX;
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       private void drawLine(int x1, int y1, int x2, int y2, MAP_SETTER area, boolean first) {
/* 156 */         int dx = x2 - x1;
/* 157 */         int dy = y2 - y1;
/* 158 */         dx = (dx < 0) ? -1 : ((dx > 0) ? 1 : 0);
/* 159 */         dy = (dy < 0) ? -1 : ((dy > 0) ? 1 : 0);
/*     */         
/* 161 */         if (first) {
/* 162 */           area.set(x1, y1);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 167 */         while (x1 != x2 || y1 != y2) {
/* 168 */           if (x1 != x2) {
/* 169 */             x1 += dx;
/*     */           }
/*     */           
/* 172 */           if (y1 != y2) {
/* 173 */             y1 += dy;
/*     */           }
/* 175 */           area.set(x1, y1);
/*     */         } 
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 183 */   public static final PLACER_TYPE OVAL = new PLACER_TYPE(true, false, D.g("ellipse"))
/*     */     {
/*     */       Icon icon() {
/* 186 */         return (SPRITES.icons()).m.place_ellispse;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       void paint(int x1, int y1, int x2, int y2, int size, MAP_SETTER area) {
/* 192 */         paintEllipse(x1, y1, x2, y2, size, false, area);
/*     */       }
/*     */     };
/*     */   
/* 196 */   public static final PLACER_TYPE OVAL_HOLLOW = new PLACER_TYPE(true, true, D.g("hollow ellipse"))
/*     */     {
/*     */       Icon icon() {
/* 199 */         return (SPRITES.icons()).m.place_ellispse_hollow;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       void paint(int x1, int y1, int x2, int y2, int size, MAP_SETTER area) {
/* 205 */         paintEllipse(x1, y1, x2, y2, size, true, area);
/*     */       }
/*     */     };
/*     */   
/*     */   public static void paintHexagon(int x1, int y1, int x2, int y2, int size, boolean hollow, MAP_SETTER area) {
/* 210 */     int centerX = (x1 + x2) / 2;
/* 211 */     int centerY = (y1 + y2) / 2;
/* 212 */     int radius = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1)) / 2;
/*     */     
/* 214 */     for (int y = -radius; y <= radius; y++) {
/* 215 */       for (int x = -radius; x <= radius; x++) {
/* 216 */         double dx = Math.abs(x);
/* 217 */         double dy = Math.abs(y);
/* 218 */         double r = dx + dy / 2.0D;
/* 219 */         if (hollow ? ((r > (radius - 1 - size) || dy > (radius - 1 - size)) && r <= radius) : (dx + dy / 2.0D <= radius)) {
/* 220 */           area.set(centerX + x, centerY + y);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void paintEllipse(int x1, int y1, int x2, int y2, int size, boolean hollow, MAP_SETTER area) {
/* 228 */     if (x1 == x2 && y1 == y2) {
/* 229 */       area.set(x1, y1);
/*     */     }
/*     */     
/* 232 */     int x11 = Math.min(x1, x2);
/* 233 */     int x22 = Math.max(x1, x2);
/* 234 */     int y11 = Math.min(y1, y2);
/* 235 */     int y22 = Math.max(y1, y2);
/*     */     
/* 237 */     double width = (x22 - x11);
/* 238 */     double height = (y22 - y11);
/*     */ 
/*     */     
/* 241 */     if ((KEYS.MAIN()).MOD.isPressed()) {
/* 242 */       width = Math.max(width, height);
/* 243 */       height = Math.max(width, height);
/*     */     } 
/*     */     
/* 246 */     double divisor = Math.max(width, height);
/* 247 */     double r2 = Math.max(width, height);
/*     */     
/* 249 */     r2 *= r2;
/* 250 */     for (double y = -height; y <= height; y++) {
/* 251 */       for (double x = -width; x <= width; x++) {
/* 252 */         double distX = x * divisor / width;
/* 253 */         double distY = y * divisor / height;
/* 254 */         double r = distX * distX + distY * distY;
/* 255 */         if (hollow ? (Math.abs(Math.sqrt(r) - Math.sqrt(r2)) < (1 + size) && r <= r2) : (r <= r2)) {
/* 256 */           area.set((int)(x11 + x), (int)(y11 + y));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 264 */   public static final PLACER_TYPE HEXAGON_HOLLOW = new PLACER_TYPE(true, true, D.g("hollow hexagon"))
/*     */     {
/*     */       Icon icon() {
/* 267 */         return (SPRITES.icons()).m.place_hex_hollow;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       void paint(int x1, int y1, int x2, int y2, int size, MAP_SETTER area) {
/* 273 */         paintHexagon(x1, y1, x2, y2, size, true, area);
/*     */       }
/*     */     };
/*     */   
/* 277 */   public static final PLACER_TYPE HEXAGON = new PLACER_TYPE(true, true, D.g("hexagon"))
/*     */     {
/*     */       Icon icon() {
/* 280 */         return (SPRITES.icons()).m.place_hex;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       void paint(int x1, int y1, int x2, int y2, int size, MAP_SETTER area) {
/* 286 */         paintHexagon(x1, y1, x2, y2, size, false, area);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/* 292 */   public static final PLACER_TYPE FILL = new PLACER_TYPE(false, true, D.g("fill"))
/*     */     {
/*     */       Icon icon() {
/* 295 */         return (SPRITES.icons()).m.place_fill;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       void paint(int x1, int y1, int x2, int y2, int size, MAP_SETTER area) {}
/*     */     };
/*     */ 
/*     */   
/* 304 */   public static final LIST<PLACER_TYPE> all = (LIST<PLACER_TYPE>)new ArrayList((Object[])new PLACER_TYPE[] { SQUARE, SQUARE_HOLLOW, BRUSH, LINE, FILL, OVAL, OVAL_HOLLOW, HEXAGON, HEXAGON_HOLLOW });
/*     */   
/*     */   final boolean drag;
/*     */   final boolean usesSize;
/*     */   final CharSequence name;
/*     */   
/*     */   private PLACER_TYPE(boolean drag, boolean usesSize, CharSequence name) {
/* 311 */     this.drag = drag;
/* 312 */     this.name = name;
/* 313 */     this.usesSize = usesSize;
/*     */   }
/*     */   
/*     */   abstract void paint(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, MAP_SETTER paramMAP_SETTER);
/*     */   
/*     */   abstract Icon icon();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PLACER_TYPE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */