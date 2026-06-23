/*     */ package settlement.room.water;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoosterImp;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.tilemap.ground.Ground;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class RoomIrrigated
/*     */ {
/*     */   public final double from;
/*     */   public final double to;
/*     */   
/*     */   public RoomIrrigated(final ROOM_IRRIGATED blue, Boostable bo, double from, double to) {
/*  33 */     this.from = from;
/*  34 */     this.to = to;
/*  35 */     BSourceInfo in = new BSourceInfo(Ground.¤¤moisture, (SPRITE)(UI.icons()).s.drop.createColored(COLOR.BLUEISH));
/*  36 */     BoosterImp boosterImp = new BoosterImp(in, from, to, true)
/*     */       {
/*     */ 
/*     */         
/*     */         public double vGet(Induvidual indu)
/*     */         {
/*  42 */           RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(indu);
/*  43 */           if (ins != null && ins.blueprint() == blue) {
/*  44 */             return CLAMP.d(RoomIrrigated.this.irrigation(ins) / RoomIrrigated.this.needed((AREA)ins), 0.0D, 1.0D);
/*     */           }
/*  46 */           return 1.0D;
/*     */         }
/*     */         
/*  49 */         private int ci = -120;
/*  50 */         private double c = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public double vGet(Player f) {
/*  56 */           return vGet(HCLASS_RACE.clP());
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(HCLASS_RACE popTime) {
/*  61 */           if (blue instanceof RoomBlueprintIns) {
/*  62 */             RoomBlueprintIns<?> p = (RoomBlueprintIns)blue;
/*  63 */             if (Math.abs(GAME.updateI() - this.ci) >= 120) {
/*  64 */               this.ci = GAME.updateI();
/*  65 */               this.c = 0.0D;
/*  66 */               int am = 0;
/*  67 */               for (int i = 0; i < p.instancesSize(); i++) {
/*  68 */                 RoomInstance ins = p.getInstance(i);
/*  69 */                 int e = ins.employees().employed();
/*  70 */                 this.c += e * CLAMP.d(RoomIrrigated.this.irrigation(ins) / RoomIrrigated.this.needed((AREA)ins), 0.0D, 1.0D);
/*  71 */                 am += e;
/*     */               } 
/*     */               
/*  74 */               if (am != 0) {
/*  75 */                 this.c /= am;
/*     */               } else {
/*  77 */                 this.c = 1.0D;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/*  84 */           return this.c;
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(FactionNPC f) {
/*  89 */           return 1.0D;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public double vGet(Faction f) {
/*  95 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(BOOSTABLE_O o) {
/* 100 */           if (o instanceof FactionNPC)
/* 101 */             return 1.0D; 
/* 102 */           return super.get(o);
/*     */         }
/*     */       };
/*     */     
/* 106 */     boosterImp.add(bo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract double irrigation(RoomInstance paramRoomInstance);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double prospectFlat(AREA area) {
/* 118 */     double n = needed(area);
/* 119 */     if (n == 0.0D) {
/* 120 */       return 0.0D;
/*     */     }
/* 122 */     double w = 0.0D;
/*     */     
/* 124 */     for (COORDINATE c : area.body()) {
/* 125 */       if (area.is(c)) {
/* 126 */         w += (SETT.GROUND()).MOISTURE_TOT.get(c);
/*     */       }
/*     */     } 
/* 129 */     return w / n;
/*     */   }
/*     */   
/*     */   public static double rawValue(AREA area) {
/* 133 */     double w = 0.0D;
/*     */     
/* 135 */     for (COORDINATE c : area.body()) {
/* 136 */       if (area.is(c)) {
/* 137 */         w += (SETT.GROUND()).MOISTURE_TOT.get(c);
/*     */       }
/*     */     } 
/* 140 */     return w / area.area();
/*     */   }
/*     */   
/*     */   public double valueProspect(AREA area) {
/* 144 */     double n = prospectFlat(area);
/* 145 */     return CLAMP.d(this.from + (this.to - this.from) * n, 0.0D, 1.0D);
/*     */   }
/*     */   
/*     */   public double needed(AREA area) {
/* 149 */     return area.area();
/*     */   }
/*     */   
/*     */   public double current(RoomInstance ins) {
/* 153 */     return CLAMP.d(irrigation(ins) / needed((AREA)ins), 0.0D, 1.0D);
/*     */   }
/*     */   
/*     */   public static interface ROOM_IRRIGATED {
/*     */     RoomIrrigated irrigation();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\RoomIrrigated.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */