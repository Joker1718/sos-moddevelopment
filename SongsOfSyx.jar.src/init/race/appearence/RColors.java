/*     */ package init.race.appearence;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.type.HTYPES;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.INT_O;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMAP;
/*     */ 
/*     */ 
/*     */ public final class RColors
/*     */ {
/*     */   public static final int BLOOD_MASK = 63;
/*     */   public final COLOR blood;
/*  26 */   static final ColorCollection dummy = new ColorCollection(COLOR.WHITE100);
/*     */   
/*     */   private final COLOR[][] clothes;
/*     */   
/*     */   private final ArrayList<ColorCollection> all;
/*  31 */   public static final COLOR grey = (COLOR)new ColorImp(170, 170, 170);
/*  32 */   public static final COLOR dead = (COLOR)new ColorImp(128, 128, 150);
/*     */   
/*     */   final RMAP<ColorCollection> collection;
/*     */ 
/*     */   
/*     */   RColors(Json data) {
/*  38 */     this.clothes = clothes("COLOR_CLOTHES", data, (STATS.EQUIP()).CLOTHES.stat().indu().max(null) + 1, 16);
/*     */     
/*  40 */     this.blood = (COLOR)new ColorImp(data, "COLOR_BLOOD");
/*     */     
/*  42 */     data = data.json("COLORS");
/*  43 */     this.all = new ArrayList(data.keys().size());
/*     */     
/*  45 */     KeyMap<ColorCollection> map = new KeyMap();
/*     */     
/*  47 */     for (String k : data.keys()) {
/*  48 */       map.put(k, new ColorCollection(this.all, data, k));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  61 */     this.collection = new RMAP("COLORS", (LIST)this.all);
/*     */   }
/*     */   
/*     */   public COLOR clothes(int level, int var) {
/*  65 */     return this.clothes[var & 0xF][level % (this.clothes[0]).length];
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
/*     */   public static class ColorCollection
/*     */     implements MAPPED
/*     */   {
/*  88 */     public static ColorCollection DUMMY = new ColorCollection(COLOR.WHITE100);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final String key;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final COLOR[] colors;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int index;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int ran;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean turnsGrayWhenOld;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean turnsWhiteWhenDead;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean addsSickColor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final DOUBLE_O<Induvidual> statDerive;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final ColorImp color;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private double ci;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private ColorCollection(ArrayList<ColorCollection> all, Json json, String key) {
/* 203 */       this.color = new ColorImp();
/* 204 */       this.ci = 0.007874015748031496D; this.key = key; json = json.json(key); this.index = all.add(this); this.turnsGrayWhenOld = json.bool("TURNS_GRAY_WHEN_OLD", false); this.turnsWhiteWhenDead = json.bool("TURNS_WHITE_WHEN_DEAD", false); this.addsSickColor = json.bool("TURNS_SICKLY", false); this.ran = this.index & 0xF; if (json.has("PICK_BY_STAT")) { INT_O.INT_OE iNT_OE; DOUBLE_O<Induvidual> statDerive = null; STAT s = STATS.STAT(json.value("PICK_BY_STAT")); if (s != null) iNT_OE = s.indu();  this.statDerive = (DOUBLE_O<Induvidual>)iNT_OE; } else { this.statDerive = null; }  LIST<ColorImp> lcols = ColorImp.cols(json, "VALUES"); COLOR[] cols = new COLOR[16]; int k = 0; for (ColorImp c : lcols) cols[k++] = (COLOR)c;  if (json.has("GENERATE_RANDOMIZE")) { double d = json.d("GENERATE_RANDOMIZE"); for (int i = k; i < 16; i++) cols[i] = (COLOR)(new ColorImp(cols[i % lcols.size()])).shade(1.0D - d * i / 16.0D);  } else { COLOR[] nn = new COLOR[cols.length]; for (int i = 0; i < cols.length; i++) nn[i] = (COLOR)lcols.get(CLAMP.i(lcols.size() * i / cols.length, 0, lcols.size() - 1));  cols = nn; }  this.colors = cols; } private ColorCollection(COLOR color) { this.color = new ColorImp(); this.ci = 0.007874015748031496D; this.key = ""; this.index = -1; this.colors = new COLOR[16]; for (int i = 0; i < 16; i++) this.colors[i] = color;  this.ran = 0; this.statDerive = null; } ColorCollection(COLOR[] color) { this.color = new ColorImp(); this.ci = 0.007874015748031496D; this.key = ""; this.index = -1; this.colors = color; this.ran = 0; this.statDerive = null; }
/*     */     public int index() { return this.index; }
/*     */     public COLOR get(int i) { return this.colors[MATH.mod(i, this.colors.length)]; }
/* 207 */     public COLOR get(Induvidual in, boolean dead) { if (this.turnsGrayWhenOld && in.hType() == HTYPES.RETIREE()) return RColors.grey;  COLOR col = null; if (this.statDerive != null) { col = get((int)(this.statDerive.getD(in) * 15.0D)); } else { col = get(STATS.RAN().get(in, 64) >> this.ran * 4); }  if (this.turnsWhiteWhenDead && dead) return (COLOR)ColorImp.TMP.interpolate(col, RColors.dead, 0.3D);  if (this.addsSickColor) { COLOR b = STATS.DISEASE().color(in); if (b != null) return colorAdd(col, b);  b = GAME.EVENT().color(in); if (b != null) return colorAdd(col, b);  }  return col; } private COLOR colorAdd(COLOR ca, COLOR cb) { int r = ca.red() & 0xFF;
/* 208 */       int r2 = cb.red() & 0xFF;
/* 209 */       if (r2 > 127) {
/* 210 */         r += r2 - 127;
/*     */       } else {
/* 212 */         r = (int)(r * r2 * this.ci);
/* 213 */       }  if (r > 255) {
/* 214 */         r = 255;
/*     */       }
/* 216 */       int g = ca.green() & 0xFF;
/* 217 */       int g2 = cb.green() & 0xFF;
/* 218 */       if (g2 > 127) {
/* 219 */         g += g2 - 127;
/*     */       } else {
/* 221 */         g = (int)(g * g2 * this.ci);
/* 222 */       }  if (g > 255) {
/* 223 */         g = 255;
/*     */       }
/* 225 */       int b = ca.blue() & 0xFF;
/* 226 */       int b2 = cb.blue() & 0xFF;
/* 227 */       if (b2 > 127) {
/* 228 */         b += b2 - 127;
/*     */       } else {
/* 230 */         b = (int)(b * b2 * this.ci);
/* 231 */       }  if (b > 255) {
/* 232 */         b = 255;
/*     */       }
/* 234 */       this.color.set(r, g, b);
/* 235 */       return (COLOR)this.color; }
/*     */ 
/*     */ 
/*     */     
/*     */     public String key() {
/* 240 */       return this.key;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private COLOR[][] clothes(String key, Json json, int levels, int vars) {
/* 246 */     Json[] is = json.jsons(key, 1, vars);
/* 247 */     COLOR[][] cols = new COLOR[vars][levels];
/* 248 */     for (int i = 0; i < cols.length; i++) {
/* 249 */       if (i >= is.length) {
/* 250 */         cols[i][levels - 1] = (COLOR)new ColorImp(is[i % is.length]);
/*     */       } else {
/* 252 */         cols[i][levels - 1] = (COLOR)new ColorImp(is[i]);
/*     */       } 
/*     */     } 
/*     */     
/* 256 */     for (int v = 0; v < vars; v++) {
/* 257 */       for (int s = levels - 2; s >= 0; s--) {
/* 258 */         double d = (s + 1.0D) / (levels - 1);
/* 259 */         cols[v][s] = (COLOR)cols[v][levels - 1].makeSaturated(d);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 264 */     return cols;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RColors.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */