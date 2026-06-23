/*     */ package settlement.room.main;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.Faction;
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import init.value.GVALUES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.employment.RoomEmployment;
/*     */ import settlement.room.main.employment.RoomEmploymentSimple;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class RoomBlueprintIns<T extends RoomInstance>
/*     */   extends RoomBlueprintImp
/*     */ {
/*  38 */   static ArrayListGrower<RoomBlueprintIns<?>> INS = new ArrayListGrower();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   private final ArrayListResize<T> all = new ArrayListResize(128);
/*     */   
/*  50 */   private int totalArea = 0;
/*  51 */   int upgrades = 0;
/*  52 */   int averageDegrade = 0;
/*     */   private final RoomEmploymentSimple employment;
/*  54 */   int roomNameI = 1;
/*  55 */   private long[] stats = new long[32];
/*  56 */   private static long statL = 1000L;
/*  57 */   private static CharSequence ¤¤Desc = "¤Production speed of: {0}";
/*     */   public final MAP_OBJECT<T> getter;
/*     */   
/*     */   static {
/*  61 */     D.ts(RoomBlueprintIns.class);
/*     */   }
/*     */   
/*     */   protected RoomBlueprintIns(int typeIndex, RoomInitData data, String key, RoomCategorySub cat, ACTION wiki) throws IOException {
/*  65 */     super(data, typeIndex, key, cat, wiki);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 219 */     this.getter = new MAP_OBJECT<T>()
/*     */       {
/*     */         
/*     */         public T get(int tile)
/*     */         {
/* 224 */           Room r = (SETT.ROOMS()).map.get(tile);
/* 225 */           if (r != null && r.blueprint() == RoomBlueprintIns.this)
/* 226 */             return (T)r; 
/* 227 */           return null;
/*     */         }
/*     */         
/*     */         public T get(int tx, int ty)
/*     */         {
/* 232 */           if (SETT.IN_BOUNDS(tx, ty))
/* 233 */             return get(tx + ty * SETT.TWIDTH); 
/* 234 */           return null; }
/*     */       }; if (data.data().has("WORK")) { this.employment = (RoomEmploymentSimple)new RoomEmployment(this, data); } else if (data.data().has("EMPLOYMENT")) { this.employment = new RoomEmploymentSimple("EMPLOYMENT", this, data); } else { this.employment = null; }  INS.add(this); String vKey = ("ROOM_" + key).replace("__", "_"); GVALUES.FACTION.push(vKey + "_AMOUNT", String.valueOf(Dic.¤¤Amount) + ": " + String.valueOf(Dic.¤¤Amount), (SPRITE)iconBig(), new DOUBLE_O<Faction>() {
/*     */           public double getD(Faction t) { return RoomBlueprintIns.this.instancesSize(); }
/*     */         },  false); GVALUES.FACTION.push(vKey + "_AREA", String.valueOf(Dic.¤¤Area) + ": " + String.valueOf(Dic.¤¤Area), (SPRITE)iconBig(), new DOUBLE_O<Faction>() {
/*     */           public double getD(Faction t) { return RoomBlueprintIns.this.totalArea; }
/*     */         },  false);
/*     */   }
/* 241 */   protected RoomBlueprintIns(int typeIndex, RoomInitData data, String key, RoomCategorySub cat) throws IOException { this(typeIndex, data, key, cat, (ACTION)null); } protected Boostable pushBo(Json json, CharSequence name, CharSequence desc, String type, boolean upgrades) { return pushBo(json, name, desc, type, upgrades, 1.0D); } protected Boostable pushBo(Json json, CharSequence name, CharSequence desc, String type, boolean upgrades, double value) { if (this.bonus != null) throw new RuntimeException();  this.bonus = BOOSTING.push(this.key, value, name, desc, (SPRITE)this.icon, BOOSTABLES.ROOMS()); if (json.has("BONUS")) { json = json.json("BONUS"); CLIMATES.pushBonuses(json, this.bonus); }  if (upgrades) upgrades().pushBonus(this, this.bonus);  return this.bonus; } protected Boostable pushBo(Json json, String type, boolean upgrades) { String desc = String.valueOf((new Str(¤¤Desc)).insert(0, this.info.names)); return pushBo(json, this.info.names, desc, type, upgrades); } protected void removeInstance(RoomInstance rem) { this.totalArea -= rem.area(); if (degrades()) this.averageDegrade -= (int)Math.ceil(100.0D * rem.getDegrade());  this.upgrades -= rem.upgrade() * rem.area(); this.all.removeOrdered(rem); for (int i = 0; i < constructor().stats().size(); i++) this.stats[i] = this.stats[i] - (long)(rem.stat(i) * statL);  } public final T getInstance(int nr) { return (T)this.all.get(nr); }
/*     */   protected void addInstance(RoomInstance t) { this.totalArea += t.area(); if (degrades()) this.averageDegrade += (int)Math.ceil(100.0D * t.getDegrade());  this.upgrades += t.upgrade() * t.area(); this.all.add(t); for (int i = 0; i < constructor().stats().size(); i++) this.stats[i] = this.stats[i] + (long)(t.stat(i) * statL);  }
/*     */   protected final void save(FilePutter saveFile) { saveFile.object(this.all); saveFile.i(this.roomNameI); saveFile.i(this.totalArea); saveFile.i(this.averageDegrade); saveFile.i(this.upgrades); saveFile.ls(this.stats); int pos = saveFile.getPosition(); saveFile.i(0); saveP(saveFile); saveFile.setAtPosition(pos, saveFile.getPosition() - pos - 4); }
/*     */   protected final void load(FileGetter saveFile) throws IOException { this.all.clear(); Object a = saveFile.object(true); this.roomNameI = saveFile.i(); this.totalArea = saveFile.i(); this.averageDegrade = saveFile.i(); this.upgrades = saveFile.i(); saveFile.ls(this.stats); if (a != null) { this.all.add((Iterable)a); } else { clear(); }  int le = saveFile.i(); int pos = saveFile.getPosition(); loadP(saveFile); if (saveFile.getPosition() - le != pos) { LOG.ln("room save corrupt in pLoad: " + this.key); saveFile.setPosition(pos + le); clearP(); }  }
/* 245 */   protected void clear() { this.roomNameI = 1; this.totalArea = 0; this.averageDegrade = 0; this.upgrades = 0; Arrays.fill(this.stats, 0L); this.all.clear(); clearP(); } public final T get(int tx, int ty) { Room r = (SETT.ROOMS()).map.get(tx, ty); if (r != null && r.blueprint() == this) return (T)(SETT.ROOMS()).map.get(tx, ty);  return null; } public final int instancesSize() { return this.all.size(); }
/*     */ 
/*     */   
/*     */   public final LIST<T> all() {
/* 249 */     return (LIST<T>)this.all;
/*     */   }
/*     */   
/*     */   public final RoomEmployment employmentExtra() {
/* 253 */     if (this.employment instanceof RoomEmployment)
/* 254 */       return (RoomEmployment)this.employment; 
/* 255 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final RoomEmploymentSimple employment() {
/* 260 */     return this.employment;
/*     */   }
/*     */   
/*     */   public boolean degrades() {
/* 264 */     return true;
/*     */   }
/*     */   
/*     */   public final int totalArea() {
/* 268 */     return this.totalArea;
/*     */   }
/*     */   
/*     */   public double degradeAverage() {
/* 272 */     if (instancesSize() == 0)
/* 273 */       return 0.0D; 
/* 274 */     return this.averageDegrade / 100.0D * instancesSize();
/*     */   }
/*     */   
/*     */   public double averageUpgrade() {
/* 278 */     if (this.totalArea == 0)
/* 279 */       return 0.0D; 
/* 280 */     return this.upgrades / this.totalArea;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAvailable(CLIMATE c) {
/* 287 */     return true;
/*     */   }
/*     */   
/*     */   public double getStat(int statIndex) {
/* 291 */     if (instancesSize() == 0) {
/* 292 */       this.stats[statIndex] = 0L;
/* 293 */       return 0.0D;
/*     */     } 
/* 295 */     return this.stats[statIndex] / statL * instancesSize();
/*     */   }
/*     */   
/*     */   protected abstract void saveP(FilePutter paramFilePutter);
/*     */   
/*     */   protected abstract void loadP(FileGetter paramFileGetter) throws IOException;
/*     */   
/*     */   protected abstract void clearP();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\RoomBlueprintIns.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */