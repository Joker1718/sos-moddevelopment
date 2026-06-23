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
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ROOM_WATER
/*     */ {
/*  31 */   private static CharSequence ¤¤irrigation = "Water Supply";
/*     */   static {
/*  33 */     D.ts(ROOM_WATER.class);
/*     */   }
/*     */   
/*     */   public final ROOM_PUMP pump;
/*     */   public final Canal canal;
/*     */   public final Drain drain;
/*     */   final WSprite sprite;
/*  40 */   final Updater updater = new Updater(this);
/*     */ 
/*     */ 
/*     */   
/*     */   final MAP_OBJECT<RoomPumpable> pumpable;
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_WATER(RoomInitData init, RoomCategorySub cat) throws IOException {
/*  49 */     this.pumpable = new MAP_OBJECT<RoomPumpable>()
/*     */       {
/*     */         public RoomPumpable get(int tile)
/*     */         {
/*  53 */           return get(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */         }
/*     */ 
/*     */         
/*     */         public RoomPumpable get(int tx, int ty) {
/*  58 */           RoomBlueprint p = (RoomBlueprint)(SETT.ROOMS()).map.blueprint.get(tx, ty);
/*  59 */           if (p != null && p instanceof RoomPumpable.ROOM_PUMPABLE)
/*  60 */             return ((RoomPumpable.ROOM_PUMPABLE)p).pumpable(tx, ty); 
/*  61 */           return null;
/*     */         }
/*     */       };
/*     */     this.pump = new ROOM_PUMP(init, cat);
/*     */     this.canal = new Canal(init, cat);
/*     */     this.drain = new Drain(init, cat);
/*     */     this.sprite = new WSprite(this, init);
/*     */   } public static void pushBonus(final RoomPumpable.ROOM_PUMPABLE blue, Boostable bo, double from, double to) {
/*  69 */     BSourceInfo in = new BSourceInfo(¤¤irrigation, (SPRITE)(UI.icons()).s.drop.createColored(COLOR.BLUEISH));
/*  70 */     BoosterImp boosterImp = new BoosterImp(in, from, to, false)
/*     */       {
/*     */ 
/*     */         
/*     */         public double vGet(Induvidual indu)
/*     */         {
/*  76 */           RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(indu);
/*  77 */           if (ins != null && ins.blueprint() == blue) {
/*  78 */             return blue.pumpable(ins.mX(), ins.mY()).irrigation(ins.mX(), ins.mY());
/*     */           }
/*  80 */           return 0.0D;
/*     */         }
/*     */         
/*  83 */         private int ci = -120;
/*  84 */         private double c = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public double vGet(Player f) {
/*  90 */           return vGet(HCLASS_RACE.clP());
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(HCLASS_RACE popTime) {
/*  95 */           if (blue instanceof RoomBlueprintIns) {
/*  96 */             RoomBlueprintIns<?> p = (RoomBlueprintIns)blue;
/*  97 */             if (Math.abs(GAME.updateI() - this.ci) >= 120) {
/*  98 */               this.ci = GAME.updateI();
/*  99 */               this.c = 0.0D;
/* 100 */               int am = 0;
/* 101 */               for (int i = 0; i < p.instancesSize(); i++) {
/* 102 */                 RoomInstance ins = p.getInstance(i);
/* 103 */                 int e = ins.employees().employed();
/* 104 */                 this.c += e * blue.pumpable(ins.mX(), ins.mY()).irrigation(ins.mX(), ins.mY());
/* 105 */                 am += e;
/*     */               } 
/*     */               
/* 108 */               if (am != 0) {
/* 109 */                 this.c /= am;
/*     */               }
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 116 */           return this.c;
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(FactionNPC f) {
/* 121 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(BOOSTABLE_O o) {
/* 126 */           if (o instanceof FactionNPC)
/* 127 */             return 1.0D; 
/* 128 */           return super.get(o);
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Faction f) {
/* 133 */           return 0.0D;
/*     */         }
/*     */       };
/*     */     
/* 137 */     boosterImp.add(bo);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\ROOM_WATER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */