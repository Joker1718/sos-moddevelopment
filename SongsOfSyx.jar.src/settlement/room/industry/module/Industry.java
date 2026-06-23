/*     */ package settlement.room.industry.module;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.GameDisposable;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.FResources;
/*     */ import game.faction.Faction;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.value.GVALUES;
/*     */ import init.value.Lockable;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.industry.module.consumption.RoomConsumptionAbs;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.DataOSimple;
/*     */ import util.text.D;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Industry
/*     */   extends RoomConsumptionAbs
/*     */   implements SAVABLE, IndustryRate, INDEXED
/*     */ {
/*  42 */   private static ArrayListGrower<Industry> all = new ArrayListGrower();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LIST<Industry> all() {
/*  55 */     return (LIST<Industry>)all;
/*     */   }
/*     */   
/*  58 */   private final ArrayListGrower<IndustryResource> outs = new ArrayListGrower();
/*     */   
/*  60 */   protected IndustryResourceOut[] outMap = new IndustryResourceOut[RESOURCES.ALL().size()];
/*     */   
/*     */   private final int index;
/*     */   public boolean isOnlyRoomDoNotUse = false;
/*  64 */   IndustryRegion reg = null;
/*     */   
/*  66 */   Lockable<Faction> lockable = GVALUES.FACTION.LOCK.empty;
/*     */   
/*  68 */   private static CharSequence ¤¤input = "Input"; public final SPRITE icon;
/*     */   static {
/*  70 */     D.ts(Industry.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Industry(RoomBlueprintImp blue, RESOURCE out, double outRate, Boostable bonus) {
/*  76 */     super(blue, bonus);
/*  77 */     this.index = all.add(this);
/*     */     
/*  79 */     this.icon = (SPRITE)out.icon();
/*     */   }
/*     */   
/*     */   public Industry(RoomBlueprintImp blue, final RESOURCE[] outs, double[] outRates, Boostable bonus) {
/*  83 */     super(blue, bonus);
/*  84 */     this.index = all.add(this);
/*  85 */     for (int i = 0; i < outs.length; i++) {
/*  86 */       RESOURCE out = outs[i];
/*  87 */       double outRate = outRates[i];
/*     */     } 
/*     */     
/*  90 */     this.icon = (SPRITE)new SPRITE.Imp(32)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/*  94 */           int w = X2 - X1;
/*  95 */           double scale = w / 32.0D;
/*  96 */           int dim = (int)(24.0D * scale);
/*  97 */           int d = (w - dim) / outs.length;
/*     */           
/*  99 */           int y1 = Y1 + (w - dim) / 2;
/* 100 */           for (int i = 0; i < outs.length; i++) {
/* 101 */             int x1 = X1 + d * i;
/* 102 */             outs[i].icon().render(r, x1, x1 + dim, y1, y1 + dim);
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Industry(RoomBlueprintImp blue, Json json, Boostable bonus) throws IOException {
/* 111 */     super(blue, bonus);
/* 112 */     this.index = all.add(this);
/* 113 */     json = json.json("INDUSTRY");
/* 114 */     if (json.has("IN")) {
/* 115 */       Json j = json.json("IN");
/* 116 */       for (String k : j.keys()) {
/* 117 */         RESOURCE res = (RESOURCE)RESOURCES.map().get(k, j);
/* 118 */         double rate = j.d(k, 0.0D, 10000.0D);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 123 */     if (json.has("OUT")) {
/* 124 */       Json j = json.json("OUT");
/* 125 */       for (String k : j.keys()) {
/* 126 */         RESOURCE res = (RESOURCE)RESOURCES.map().get(k, j);
/*     */         
/* 128 */         if (j.jsonIs(k)) {
/* 129 */           Json jj = j.json(k);
/* 130 */           double d1 = jj.d("PLAYER", 0.0D, 100000.0D);
/* 131 */           double AIRate = jj.dTry("AI_RATE", 0.0D, 100000.0D, d1);
/* 132 */           double AIRecovery = jj.dTry("AI_RECOVERY", 0.0D, 100000.0D, 1.0D);
/*     */           continue;
/*     */         } 
/* 135 */         double rate = j.d(k, 0.0D, 10000.0D);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 141 */     if (json.has("ICON")) {
/* 142 */       this.icon = (SPRITE)SPRITES.icons().get(json);
/*     */     } else {
/* 144 */       this.icon = (SPRITE)new SPRITE.Imp(32)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 148 */             int w = X2 - X1;
/* 149 */             double scale = w / 32.0D;
/* 150 */             int dim = (int)(24.0D * scale);
/* 151 */             int d = (w - dim) / Industry.this.outs().size();
/*     */             
/* 153 */             int y1 = Y1 + (w - dim) / 2;
/* 154 */             for (int i = 0; i < Industry.this.outs.size(); i++) {
/* 155 */               int x1 = X1 + d * i;
/* 156 */               ((IndustryResource)Industry.this.outs.get(i)).resource.icon().render(r, x1, x1 + dim, y1, y1 + dim);
/*     */             } 
/*     */           }
/*     */         };
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
/*     */   public Lockable<Faction> lockable() {
/* 172 */     return this.lockable;
/*     */   }
/*     */   
/*     */   public Boostable consumption() {
/* 176 */     return this.conBonus;
/*     */   }
/*     */   
/*     */   public IndustryResource out(RESOURCE res) {
/* 180 */     return this.outMap[res.index()];
/*     */   }
/*     */   
/*     */   public LIST<IndustryResource> outs() {
/* 184 */     return (LIST<IndustryResource>)this.outs;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final class IndustryResourceOut
/*     */     extends IndustryResource
/*     */   {
/*     */     IndustryResourceOut(DataOSimple<ROOM_IDATA_INSTANCE> data, RESOURCE res, double rate, double AIRate, double AIRecovery) {
/* 193 */       super(data, Industry.this.outs.size(), res, rate, AIRate, AIRecovery);
/* 194 */       Industry.this.outs.add(this);
/* 195 */       Industry.this.outMap[this.resource.index()] = this;
/* 196 */       Industry.this.allRes.add(this);
/*     */     }
/*     */ 
/*     */     
/*     */     public int inc(ROOM_IDATA_INSTANCE r, double amount, boolean record) {
/* 201 */       if (!Double.isFinite(amount)) {
/* 202 */         GAME.Warn("" + amount);
/* 203 */         return 0;
/*     */       } 
/* 205 */       if (!Double.isFinite(this.day.getD(r))) {
/* 206 */         this.day.setD(r, 0.0D);
/*     */       }
/*     */       
/* 209 */       int old = (int)this.day.getD(r);
/* 210 */       this.day.incD(r, amount);
/* 211 */       int now = (int)this.day.getD(r);
/* 212 */       int d = now - old;
/* 213 */       if (d != 0) {
/* 214 */         if (record)
/* 215 */           GAME.player().res().inc(this.resource, FResources.RTYPE.PRODUCED, d); 
/* 216 */         this.year.inc(r, d);
/* 217 */         this.history.inc(d);
/* 218 */         (GAME.count()).CRAFTED.inc(1);
/*     */       } 
/* 220 */       return d;
/*     */     }
/*     */ 
/*     */     
/*     */     protected double getEffort(Humanoid skill, ROOM_IDATA_INSTANCE r, double workSeconds) {
/* 225 */       return IndustryUtil.calcProductionRate(this.rateSeconds * workSeconds, skill, Industry.this, (RoomInstance)r);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IndustryRegion reg() {
/* 231 */     return this.reg;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 236 */     return this.index;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static LIST<Industry> createIndustries(RoomBlueprintImp blue, RoomInitData init, RoomBoost[] boosts, Boostable bonus, DOUBLE_O<Region> regBonus) throws IOException {
/* 242 */     Json[] js = init.data().jsons("INDUSTRIES", 1);
/*     */     
/* 244 */     ArrayList<Industry> res = new ArrayList(js.length); byte b; int i; Json[] arrayOfJson1;
/* 245 */     for (i = (arrayOfJson1 = js).length, b = 0; b < i; ) { Json j = arrayOfJson1[b];
/* 246 */       Industry industry = new Industry(blue, j, bonus);
/* 247 */       if (industry.outs().size() == 0)
/* 248 */         j.error(blue.key + " has no out resources declared. This can be due to an outdated mod.", "INDUSTRIES");  byte b1; int k; RoomBoost[] arrayOfRoomBoost;
/* 249 */       for (k = (arrayOfRoomBoost = boosts).length, b1 = 0; b1 < k; ) { RoomBoost roomBoost = arrayOfRoomBoost[b1];
/* 250 */         industry.roomBoosts.add(roomBoost);
/*     */         b1++; }
/*     */       
/* 253 */       res.add(industry); b++; }
/*     */     
/* 255 */     if (res.size() > 1) {
/* 256 */       int j = 0;
/* 257 */       for (int k = 0; k < res.size(); k++) {
/* 258 */         String desc = "";
/* 259 */         for (IndustryResource ir : ((Industry)res.get(k)).ins()) {
/* 260 */           if (desc.length() > 0)
/* 261 */             desc = desc + " + "; 
/* 262 */           desc = desc + desc;
/*     */         } 
/* 264 */         desc = desc + " -> " + desc;
/* 265 */         ((Industry)res.get(k)).lockable = GVALUES.FACTION.LOCK.push("ROOM_" + blue.key + "_RECIPE_" + j, String.valueOf(blue.info.name) + ": " + String.valueOf(blue.info.name), desc, ((Industry)res.get(k)).icon);
/* 266 */         j++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 273 */     int ii = 0;
/* 274 */     for (Industry industry : res) {
/* 275 */       if (industry.ins().size() > 0 && industry.outs().size() > 0) {
/*     */         
/* 277 */         Icon icon = (SPRITES.icons()).l.star.twin(industry.icon, DIR.C, 1);
/*     */         
/* 279 */         industry.conBonus = BOOSTING.push("CONSUMPTION_" + blue.key + "_" + ii, 1.0D, String.valueOf(blue.info.name) + " " + String.valueOf(blue.info.name) + ": " + String.valueOf(¤¤input), industry.lockable.desc, (SPRITE)icon, BOOSTABLES.CONSUMPTION());
/* 280 */         ii++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 285 */     return (LIST<Industry>)res;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LIST<Industry> createIndustries(RoomBlueprintImp blue, RoomInitData init, RoomBoost[] boosts, Boostable bonus) throws IOException {
/* 292 */     DOUBLE_O<Region> rr = new DOUBLE_O<Region>()
/*     */       {
/*     */         public double getD(Region t)
/*     */         {
/* 296 */           return 1.0D;
/*     */         }
/*     */       };
/*     */     
/* 300 */     return createIndustries(blue, init, boosts, bonus, rr);
/*     */   }
/*     */   
/*     */   private static RESOURCE unique(Industry ins, LIST<Industry> others) {
/* 304 */     RESOURCE res = ((IndustryResource)ins.outs().get(0)).resource;
/* 305 */     boolean unique = true;
/* 306 */     for (Industry i : others) {
/* 307 */       if (i != ins && ((IndustryResource)i.outs().get(0)).resource == res)
/* 308 */         unique = false; 
/*     */     } 
/* 310 */     if (unique)
/* 311 */       return res; 
/* 312 */     for (IndustryResource r : ins.ins()) {
/* 313 */       unique = true;
/* 314 */       for (Industry i : others) {
/* 315 */         if (i != ins) {
/* 316 */           for (IndustryResource or : i.ins()) {
/* 317 */             if (or.resource == r.resource) {
/* 318 */               unique = false;
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/* 323 */       if (unique)
/* 324 */         return r.resource; 
/*     */     } 
/* 326 */     return res;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\Industry.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */