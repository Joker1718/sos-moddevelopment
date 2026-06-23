/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.race.Race;
/*     */ import init.race.appearence.RType;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATInduOnly;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ public final class StatsAppearance
/*     */   extends StatCollection
/*     */ {
/*     */   public static final int NAME_MAX = 4095;
/*     */   public final INT_O.INT_OE<Induvidual> nameData;
/*  39 */   public final NamePart nameFirst = new NamePart(true);
/*  40 */   public final NamePart nameLast = new NamePart(false);
/*     */   
/*     */   public final INT_O.INT_OE<Induvidual> gender;
/*     */   
/*     */   public final LIST<INT_O.INT_OE<Induvidual>> all;
/*     */   public final INT_O.INT_OE<Induvidual> favo;
/*     */   public final STAT dead;
/*     */   private final ColorImp color;
/*     */   private double ci;
/*     */   
/*     */   public StatsAppearance(StatsInit init) {
/*  51 */     super(init, "APPEARANCE", "", "");
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
/* 134 */     this.color = new ColorImp();
/* 135 */     this.ci = 0.007874015748031496D;
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
/* 229 */     this.ss = new Str(32); init.count.getClass(); this.nameData = (INT_O.INT_OE<Induvidual>)new DataO.DataInt(init.count, "APPEARENCE_NAME"); init.count.getClass(); this.gender = (INT_O.INT_OE<Induvidual>)new DataO.DataNibble(init.count, "APPEARENCE_GENDER"); init.savers.put("APPEARENCE_SCRAP", new SAVABLE() { public void save(FilePutter file) { StatsAppearance.this.nameFirst.save(file); StatsAppearance.this.nameLast.save(file); } public void load(FileGetter file) throws IOException { StatsAppearance.this.nameFirst.load(file); StatsAppearance.this.nameLast.load(file); } public void clear() { StatsAppearance.this.nameFirst.clear(); StatsAppearance.this.nameLast.clear(); } }
/*     */       ); init.count.getClass(); this.dead = (STAT)new STATInduOnly("DEAD", init, (INT_O.INT_OE)new DataO.DataBit(init.count, "APPEARENCE_DEAD")); LinkedList<INT_O.INT_OE<Induvidual>> tt = new LinkedList(); tt.add(this.nameData); tt.add(this.gender); init.count.getClass(); this.favo = (INT_O.INT_OE<Induvidual>)new DataO.DataBit(init.count, "FFAVOURITE"); tt.add(this.favo); this.all = (LIST<INT_O.INT_OE<Induvidual>>)new ArrayList((Iterable)tt); init.copier.add((Iterable)this.all); init.onConstruct.add(new StatsInit.StatInitable() { public void init(Induvidual h) { double ri = RND.rFloat((h.race().appearance()).tMax); int gi = 0; for (RType t : (h.race().appearance()).types) { ri -= t.spec.occurrence; if (ri <= 0.0D) { gi = CLAMP.i(gi, 0, (h.race().appearance()).types.size() - 1); StatsAppearance.this.gender.set(h, gi); break; }  gi++; }  StatsAppearance.this.nameFirst.randmoize(h); StatsAppearance.this.nameLast.randmoize(h); } }
/*     */       );
/* 232 */   } private RType get(Induvidual i) { if (i.hType() == HTYPES.CHILD()) return (i.race().appearance()).child;  return (RType)(i.race().appearance()).types.getC(this.gender.get(i)); } public COLOR colorSkin(Race race, int gender, int ran) { RType r = (RType)(race.appearance()).types.getC(gender); return r.spec.skin.get(ran); } public COLOR colorSkin(Induvidual i) { COLOR a = (get(i)).spec.skin.get(i, false); COLOR col = STATS.DISEASE().color(i); if (col != null) return colorAdd(a, col);  col = GAME.EVENT().color(i); if (col != null) return colorAdd(a, col);  return a; } private COLOR colorAdd(COLOR ca, COLOR cb) { int r = ca.red() & 0xFF; int r2 = cb.red() & 0xFF; if (r2 > 127) { r += r2 - 127; } else { r = (int)(r * r2 * this.ci); }  if (r > 255) r = 255;  int g = ca.green() & 0xFF; int g2 = cb.green() & 0xFF; if (g2 > 127) { g += g2 - 127; } else { g = (int)(g * g2 * this.ci); }  if (g > 255) g = 255;  int b = ca.blue() & 0xFF; int b2 = cb.blue() & 0xFF; if (b2 > 127) { b += b2 - 127; } else { b = (int)(b * b2 * this.ci); }  if (b > 255) b = 255;  this.color.set(r, g, b); return (COLOR)this.color; } public COLOR colorClothes(Induvidual i) { if (i.hType().isHostile()) return clothesEnemy[STATS.RAN().get(i, 0, 3) & 0x7];  if (i.hType() == HTYPES.SLAVE() || i.hType() == HTYPES.PRISONER()) return clothesSlave[STATS.RAN().get(i, 3, 3) & 0x7];  if (i.hType() == HTYPES.NOBILITY()) return clothesNoble[0];  if (i.hType() == HTYPES.TOURIST()) return clothesTourist[STATS.RAN().get(i, 3, 4) & 0xF];  return (i.race().appearance()).colors.clothes((STATS.EQUIP()).CLOTHES.stat().indu().get(i), STATS.RAN().get(i, 6, 3) & 0x7); } public CharSequence name(Induvidual i) { return name(i.race(), i.hType(), this.gender.get(i), this.nameData.get(i)); }
/*     */    private static final COLOR[] clothesSlave = new COLOR[] { (COLOR)(new ColorImp(114, 67, 36)).shade(0.5D), (COLOR)(new ColorImp(119, 67, 36)).shade(0.5D), (COLOR)(new ColorImp(114, 72, 36)).shade(0.5D), (COLOR)(new ColorImp(114, 67, 41)).shade(0.5D), (COLOR)(new ColorImp(119, 72, 36)).shade(0.5D), (COLOR)(new ColorImp(114, 72, 41)).shade(0.5D), (COLOR)(new ColorImp(119, 67, 41)).shade(0.5D), (COLOR)(new ColorImp(119, 72, 41)).shade(0.5D) }; private static final COLOR[] clothesTourist = (COLOR[])COLOR.interpolate((COLOR)new ColorImp(80, 80, 127), (COLOR)new ColorImp(40, 40, 62), 16); public static final COLOR[] clothesEnemy = new COLOR[] { (COLOR)new ColorImp(20, 20, 20), (COLOR)new ColorImp(25, 20, 20), (COLOR)new ColorImp(20, 25, 20), (COLOR)new ColorImp(20, 20, 25), (COLOR)new ColorImp(25, 25, 20), (COLOR)new ColorImp(20, 25, 25), (COLOR)new ColorImp(25, 20, 25), (COLOR)new ColorImp(30, 20, 20) }; public static final COLOR[] clothesNoble = new COLOR[] { (COLOR)new ColorImp(84, 0, 127) }; private final Str ss; public COLOR colorLegs(Induvidual i) {
/*     */     return (get(i)).spec.leg.get(i, false);
/*     */   } public CharSequence name(Race r, HTYPE t, int gender, int nameData) {
/* 236 */     this.ss.clear();
/* 237 */     this.ss.add(this.nameFirst.name(r, t, gender, nameData));
/* 238 */     this.ss.s();
/* 239 */     this.ss.add(this.nameLast.name(r, t, gender, nameData));
/* 240 */     return (CharSequence)this.ss;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCustomName(Induvidual i, String name) {
/* 245 */     CharSequence first = Dic.empty;
/* 246 */     CharSequence last = Dic.empty;
/* 247 */     if (name.indexOf(" ") > 0) {
/* 248 */       first = name.subSequence(0, name.indexOf(" "));
/* 249 */       last = name.subSequence(name.indexOf(" ") + 1, name.length());
/*     */     } else {
/* 251 */       first = name;
/* 252 */       last = Dic.empty;
/*     */     } 
/* 254 */     this.nameFirst.setCustom(i, first);
/* 255 */     this.nameLast.setCustom(i, last);
/*     */   }
/*     */   
/*     */   public void portraitRender(SPRITE_RENDERER r, Induvidual a, int x, int y, int scale) {
/* 259 */     if (a.hType() == HTYPES.CHILD() || a.hType() == HTYPES.CHILD_SLAVE()) {
/* 260 */       (a.race().appearance()).child.portrait.render(r, x, y, a, scale);
/*     */     } else {
/*     */       
/* 263 */       ((RType)(a.race().appearance()).types.getC(this.gender.get(a))).portrait.render(r, x, y, a, scale);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public class NamePart
/*     */   {
/*     */     private final Bits bData;
/*     */ 
/*     */     
/*     */     private final Bit bC;
/*     */     
/* 276 */     private final ArrayList<Str> allNames = new ArrayList(4096);
/* 277 */     private int kk = 1;
/* 278 */     private final Str ss = new Str(1024);
/*     */     private boolean first;
/*     */     
/*     */     NamePart(boolean first) {
/* 282 */       int scroll = first ? 0 : 1;
/* 283 */       this.bData = new Bits(4095 << 16 * scroll);
/* 284 */       this.bC = new Bit(4096 << 16 * scroll);
/* 285 */       this.allNames.add(new Str(1));
/* 286 */       this.first = first;
/*     */     }
/*     */     
/*     */     public CharSequence name(Race r, HTYPE t, int gender, int nameData) {
/* 290 */       if (this.bC.is(nameData)) {
/* 291 */         return (CharSequence)this.allNames.get(this.bData.get(nameData));
/*     */       }
/* 293 */       this.ss.clear();
/* 294 */       if (this.first) {
/* 295 */         this.ss.add((CharSequence)((RType)(r.appearance()).types.getC(gender)).names.firstNames.getC(this.bData.get(nameData)));
/*     */       } else {
/* 297 */         this.ss.add((CharSequence)((RType)(r.appearance()).types.getC(gender)).names.lastNames.getC(this.bData.get(nameData)));
/*     */       } 
/* 299 */       return (CharSequence)this.ss;
/*     */     }
/*     */     
/*     */     public CharSequence name(Induvidual i) {
/* 303 */       return name(i.race(), i.hType(), StatsAppearance.this.gender.get(i), StatsAppearance.this.nameData.get(i));
/*     */     }
/*     */     
/*     */     public void randmoize(Induvidual i) {
/* 307 */       int g = StatsAppearance.this.gender.get(i);
/* 308 */       int max = 0;
/* 309 */       if (this.first) {
/* 310 */         max = ((RType)(i.race().appearance()).types.getC(g)).names.firstNames.size();
/*     */       } else {
/* 312 */         max = ((RType)(i.race().appearance()).types.getC(g)).names.lastNames.size();
/*     */       } 
/* 314 */       int data = StatsAppearance.this.nameData.get(i);
/* 315 */       data = this.bC.set(data, false);
/* 316 */       data = this.bData.set(data, RND.rInt(max));
/* 317 */       StatsAppearance.this.nameData.set(i, data);
/*     */     }
/*     */ 
/*     */     
/*     */     public void copy(Induvidual i, int nameDataToCopy) {
/* 322 */       if (this.bC.is(nameDataToCopy)) {
/* 323 */         CharSequence nn = (CharSequence)this.allNames.get(this.bData.get(nameDataToCopy));
/* 324 */         setCustom(i, nn);
/*     */       } else {
/* 326 */         int data = this.bData.set(StatsAppearance.this.nameData.get(i), this.bData.get(nameDataToCopy));
/* 327 */         StatsAppearance.this.nameData.set(i, data);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void setCustom(Induvidual i, CharSequence cc) {
/* 332 */       if (cc.length() == 0) {
/* 333 */         int j = StatsAppearance.this.nameData.get(i);
/* 334 */         j = this.bData.set(j, 0);
/* 335 */         j = this.bC.set(j, true);
/* 336 */         StatsAppearance.this.nameData.set(i, j);
/*     */         
/*     */         return;
/*     */       } 
/* 340 */       if (this.kk >= this.allNames.max())
/* 341 */         this.kk = 1; 
/* 342 */       while (this.kk >= this.allNames.size()) {
/* 343 */         this.allNames.add(new Str(32));
/*     */       }
/* 345 */       ((Str)this.allNames.get(this.kk)).clear().add(cc);
/*     */       
/* 347 */       int data = StatsAppearance.this.nameData.get(i);
/* 348 */       data = this.bData.set(data, this.kk);
/* 349 */       data = this.bC.set(data, true);
/* 350 */       StatsAppearance.this.nameData.set(i, data);
/* 351 */       this.kk++;
/*     */     }
/*     */     
/*     */     void save(FilePutter file) {
/* 355 */       file.i(this.kk);
/* 356 */       file.i(this.allNames.size());
/* 357 */       for (int i = 0; i < this.allNames.size(); i++) {
/* 358 */         ((Str)this.allNames.get(i)).save(file);
/*     */       }
/*     */     }
/*     */     
/*     */     void load(FileGetter file) throws IOException {
/* 363 */       this.kk = file.i();
/* 364 */       if (this.kk == 0)
/* 365 */         this.kk = 1; 
/* 366 */       int am = file.i();
/* 367 */       this.allNames.clearSloppy();
/* 368 */       for (int i = 0; i < am; i++) {
/* 369 */         this.allNames.add(new Str(32));
/* 370 */         ((Str)this.allNames.get(this.allNames.size() - 1)).load(file);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     void clear() {
/* 376 */       this.kk = 1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsAppearance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */