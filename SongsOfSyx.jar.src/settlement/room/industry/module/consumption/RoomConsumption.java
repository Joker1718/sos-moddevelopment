/*     */ package settlement.room.industry.module.consumption;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.Boostable;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.industry.module.RoomBoost;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataOSimple;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public class RoomConsumption extends RoomConsumptionAbs {
/*  28 */   public final ArrayListGrower<ExtraInfo> extra = new ArrayListGrower();
/*     */ 
/*     */   
/*     */   public RoomConsumption(RoomBlueprintImp blue, Json json, Boostable bonus) {
/*  32 */     super(blue, bonus);
/*     */     
/*  34 */     if (json.has("CONSUMPTION")) {
/*  35 */       json = json.json("CONSUMPTION");
/*     */       
/*  37 */       for (String k : json.keys()) {
/*  38 */         RESOURCE res = (RESOURCE)RESOURCES.map().get(k, json);
/*  39 */         Json j = json.json(k);
/*  40 */         double rate = j.d("RATE", 0.0D, 10000.0D);
/*     */ 
/*     */         
/*  43 */         this.extra.add(new ExtraInfo(j, this.data));
/*     */       } 
/*     */     } 
/*     */     
/*  47 */     final INFO info = new INFO(Dic.¤¤Resources, "");
/*     */     
/*  49 */     double m = 1.0D;
/*  50 */     for (IndustryResource r : this.allIns) {
/*  51 */       m += boost(r);
/*     */     }
/*  53 */     final double max = m;
/*     */     
/*  55 */     this.roomBoosts.add(new RoomBoost()
/*     */         {
/*     */           public INFO info()
/*     */           {
/*  59 */             return info;
/*     */           }
/*     */ 
/*     */           
/*     */           public double get(RoomInstance r) {
/*  64 */             double m = 1.0D;
/*  65 */             for (IndustryResource res : RoomConsumption.this.allIns) {
/*  66 */               if (RoomConsumption.this.stored(res).get(r) > 0)
/*  67 */                 m += RoomConsumption.this.boost(res); 
/*     */             } 
/*  69 */             return m;
/*     */           }
/*     */ 
/*     */           
/*     */           public double max() {
/*  74 */             return max;
/*     */           }
/*     */ 
/*     */           
/*     */           public double min() {
/*  79 */             return 1.0D;
/*     */           }
/*     */         });
/*  82 */     Icon icon = (SPRITES.icons()).l.star.twin((SPRITE)blue.iconBig(), DIR.C, 1);
/*     */     
/*  84 */     this.conBonus = BOOSTING.push("CONSUMPTION_" + blue.key, 1.0D, String.valueOf(Dic.¤¤ConsumptionRate) + ": " + String.valueOf(Dic.¤¤ConsumptionRate), String.valueOf(Dic.¤¤ConsumptionRate) + ": " + String.valueOf(Dic.¤¤ConsumptionRate), (SPRITE)icon, BOOSTABLES.CONSUMPTION());
/*     */   }
/*     */   
/*     */   public boolean enabled(IndustryResource res, ROOM_IDATA_INSTANCE ins) {
/*  88 */     return (((ExtraInfo)this.extra.get(res.index())).enabled.get(ins) == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void enabledToggle(IndustryResource res, ROOM_IDATA_INSTANCE ins, RoomInstance i) {
/*  93 */     ((ExtraInfo)this.extra.get(res.index())).enabled.set(ins, ((ExtraInfo)this.extra.get(res.index())).enabled.get(ins) + 1 & 0x1);
/*  94 */     ins.getWork().resetResourceSearch();
/*  95 */     if (!enabled(res, ins)) {
/*  96 */       releaseResources(i, ins);
/*     */     }
/*     */   }
/*     */   
/*     */   public double boost(IndustryResource res) {
/* 101 */     return ((ExtraInfo)this.extra.get(res.index())).boost;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public INT_O.INT_OE<ROOM_IDATA_INSTANCE> stored(IndustryResource res) {
/* 107 */     return ((ExtraInfo)this.extra.get(res.index())).amount;
/*     */   }
/*     */   
/*     */   public INT_O.INT_OE<ROOM_IDATA_INSTANCE> reseved(IndustryResource res) {
/* 111 */     return ((ExtraInfo)this.extra.get(res.index())).reserved;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldFecth(IndustryResource r, ROOM_IDATA_INSTANCE ins, RoomInstance emp) {
/* 116 */     if (!enabled(r, ins))
/* 117 */       return false; 
/* 118 */     if (!ins.getWork().resourceShouldSearch(r.resource)) {
/* 119 */       return false;
/*     */     }
/* 121 */     double am = ((ExtraInfo)this.extra.get(r.index())).amount.get(ins);
/* 122 */     double res = ((ExtraInfo)this.extra.get(r.index())).reserved.get(ins);
/* 123 */     double min = Math.ceil(emp.employees().employed() * r.rate);
/* 124 */     return (am + res < min);
/*     */   }
/*     */ 
/*     */   
/*     */   static class ExtraInfo
/*     */   {
/*     */     public final double boost;
/*     */     public final INT_O.INT_OE<ROOM_IDATA_INSTANCE> enabled;
/*     */     public final INT_O.INT_OE<ROOM_IDATA_INSTANCE> amount;
/*     */     public final INT_O.INT_OE<ROOM_IDATA_INSTANCE> reserved;
/*     */     
/*     */     ExtraInfo(Json j, DataOSimple<ROOM_IDATA_INSTANCE> data) {
/* 136 */       this.boost = j.d("BONUS", 0.0D, 1000.0D);
/* 137 */       data.getClass(); this.enabled = (INT_O.INT_OE<ROOM_IDATA_INSTANCE>)new DataOSimple.DataBit(data);
/* 138 */       data.getClass(); this.amount = (INT_O.INT_OE<ROOM_IDATA_INSTANCE>)new DataOSimple.DataInt(data);
/* 139 */       data.getClass(); this.reserved = (INT_O.INT_OE<ROOM_IDATA_INSTANCE>)new DataOSimple.DataShort(data);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void releaseResources(RoomInstance ins, ROOM_IDATA_INSTANCE insc) {
/* 150 */     double stations = 0.0D;
/*     */     
/* 152 */     for (COORDINATE c : ins.body()) {
/* 153 */       if (ins.is(c) && insc.getWork().getJob(c) != null) {
/* 154 */         stations++;
/*     */       }
/*     */     } 
/*     */     
/* 158 */     if (stations > 0.0D)
/*     */     {
/* 160 */       for (IndustryResource res : ins()) {
/*     */         
/* 162 */         int delta = (int)Math.ceil(stored(res).get(insc) / stations);
/*     */         
/* 164 */         for (COORDINATE c : ins.body()) {
/* 165 */           if (ins.is(c) && insc.getWork().getJob(c) != null) {
/* 166 */             int am = Math.min(delta, stored(res).get(insc));
/* 167 */             if (am > 0) {
/* 168 */               for (int di = 0; di < DIR.ALL.size(); di++) {
/* 169 */                 int dx = c.x() + ((DIR)DIR.ALL.get(di)).x();
/* 170 */                 int dy = c.y() + ((DIR)DIR.ALL.get(di)).y();
/* 171 */                 if (!(SETT.PATH()).solidity.is(dx, dy)) {
/* 172 */                   (SETT.THINGS()).resources.create(dx, dy, res.resource, am);
/* 173 */                   stored(res).inc(insc, -am);
/*     */                   break;
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/* 182 */     for (IndustryResource res : ins()) {
/* 183 */       int am = stored(res).get(insc);
/* 184 */       if (am > 0) {
/* 185 */         (SETT.THINGS()).resources.create(ins.mX(), ins.mY(), res.resource, am);
/*     */       }
/* 187 */       stored(res).set(insc, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double consumptionRate(RoomInstance ins, Humanoid h, IndustryResource res) {
/* 195 */     ROOM_IDATA_INSTANCE insi = (ROOM_IDATA_INSTANCE)ins;
/* 196 */     if (stored(res).get(insi) > 0) {
/* 197 */       return super.consumptionRate(ins, h, res);
/*     */     }
/* 199 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public static interface ROOM_CONSUMPTION_HASER {
/*     */     RoomConsumption consumption();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\consumption\RoomConsumption.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */