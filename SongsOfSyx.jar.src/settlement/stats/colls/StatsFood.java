/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResG;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.NEEDS;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.service.food.canteen.ROOM_CANTEEN;
/*     */ import settlement.room.service.food.eatery.ROOM_EATERY;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFakeRace;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import settlement.stats.stat.StatDecree;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.data.DataO;
/*     */ import util.info.INFO;
/*     */ import util.race.PERMISSION;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StatsFood
/*     */   extends StatCollection
/*     */ {
/*     */   public static final int MAX_RATIONS = 4;
/*     */   public final STAT FOOD_PREFFERENCE;
/*     */   public final STAT FOOD_DAYS;
/*     */   public final STAT FOOD;
/*     */   public final STAT DRINK;
/*     */   public final STAT DRINK_PREFFERENCE;
/*     */   public final STAT STARVATION;
/*  50 */   private final All[] foodAllowed = new All[HCLASSES.ALL().size()];
/*     */   
/*     */   private final LIST<PERMISSION> food;
/*  53 */   private static CharSequence ¤¤name = "Food";
/*  54 */   private static CharSequence ¤¤desc = "Stats related to food and hunger.";
/*     */   
/*     */   static {
/*  57 */     D.ts(StatsFood.class);
/*     */   }
/*     */   
/*     */   public StatsFood(StatsInit init) {
/*  61 */     super(init, "FOOD", ¤¤name, ¤¤desc);
/*  62 */     D.gInit(this);
/*     */     
/*  64 */     init.count.getClass(); this.STARVATION = (STAT)new STATData("STARVATION", init, (DataO.DataAbs)new DataO.DataBit(init.count, "FOOD_STARVE"));
/*  65 */     init.count.getClass(); this.FOOD_PREFFERENCE = (STAT)new STATData("FOOD_PREFFERENCE", init, (DataO.DataAbs)new DataO.DataNibble(init.count, "FOOD_PREF"));
/*  66 */     init.onArrivalStats.add(this.FOOD_PREFFERENCE);
/*  67 */     for (int i = 0; i < this.foodAllowed.length; i++) {
/*  68 */       this.foodAllowed[i] = new All();
/*     */     }
/*     */     
/*  71 */     this.FOOD_DAYS = (STAT)new STATFakeRace("FOOD_DAYS", init)
/*     */       {
/*     */         private double am;
/*  74 */         private int lastT = -1;
/*     */ 
/*     */         
/*     */         public int dataDivider() {
/*  78 */           return 24;
/*     */         }
/*     */ 
/*     */         
/*     */         protected double getDD(Race race) {
/*  83 */           if (GAME.updateI() == this.lastT) {
/*  84 */             return this.am;
/*     */           }
/*  86 */           this.lastT = GAME.updateI();
/*     */           
/*  88 */           double a = 0.0D;
/*  89 */           for (int ei = 0; ei < RESOURCES.EDI().all().size(); ei++) {
/*  90 */             ResG r = (ResG)RESOURCES.EDI().all().get(ei);
/*  91 */             double aa = (SETT.ROOMS()).STOCKPILE.tally().amountTotal(r.resource);
/*  92 */             a += aa;
/*     */           } 
/*     */           int ri;
/*  95 */           for (ri = 0; ri < (SETT.ROOMS()).EATERIES.size(); ri++) {
/*  96 */             ROOM_EATERY e = (ROOM_EATERY)(SETT.ROOMS()).EATERIES.get(ri);
/*  97 */             double aa = e.totalFood();
/*  98 */             a += aa;
/*     */           } 
/*     */           
/* 101 */           for (ri = 0; ri < (SETT.ROOMS()).CANTEENS.size(); ri++) {
/* 102 */             ROOM_CANTEEN e = (ROOM_CANTEEN)(SETT.ROOMS()).CANTEENS.get(ri);
/* 103 */             double aa = e.totalFood();
/* 104 */             a += aa;
/*     */           } 
/*     */           
/* 107 */           double needed = 0.0D;
/*     */           
/* 109 */           for (int ci = 0; ci < HCLASSES.ALL().size(); ci++) {
/* 110 */             HCLASS c = (HCLASS)HCLASSES.ALL().get(ci);
/* 111 */             if (c.player) {
/* 112 */               for (int i = 0; i < RACES.all().size(); i++) {
/* 113 */                 Race r = (Race)RACES.all().get(i);
/* 114 */                 needed += (NEEDS.TYPES()).HUNGER.rate.get((BOOSTABLE_O)c.get(r)) * POP.physical(c, r) * StatsFood.this.FOOD.decree().get(c, r);
/*     */               } 
/*     */             }
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 122 */           if (needed == 0.0D) {
/* 123 */             this.am = ((a > 0.0D) ? true : false);
/*     */           } else {
/* 125 */             this.am = a / needed;
/* 126 */           }  this.am /= dataDivider();
/* 127 */           return this.am;
/*     */         }
/*     */       };
/* 130 */     this.FOOD_DAYS.info().setInt();
/* 131 */     this.FOOD_DAYS.info().setMatters(true, false);
/*     */     
/* 133 */     StatDecree d = new StatDecree("FOOD_RATIONS_DECREE", init, 2, 4, 2, D.g("RationsT", "Target Food servings."), 1);
/* 134 */     d.setInt();
/*     */ 
/*     */     
/* 137 */     init.count.getClass(); this.FOOD = (STAT)new STATData("FOOD_RATIONS", init, (DataO.DataAbs)new DataO.DataNibble(init.count, "FOOD_RATIONS", 3));
/* 138 */     this.FOOD.addDecree(d);
/* 139 */     init.onArrivalStats.add(this.FOOD);
/*     */     
/* 141 */     d = new StatDecree("DRINK_RATION_DECREE", init, 2, 4, 2, D.g("DrinkT", "Target Drink servings"), 1);
/* 142 */     d.setInt();
/* 143 */     init.count.getClass(); this.DRINK = (STAT)new STATData("DRINK_RATIONS", init, (DataO.DataAbs)new DataO.DataNibble(init.count, "DRINK_RATIONS", 5));
/* 144 */     this.DRINK.addDecree(d);
/* 145 */     init.count.getClass(); this.DRINK_PREFFERENCE = (STAT)new STATData("DRINK_PREFFERENCE", init, (DataO.DataAbs)new DataO.DataNibble(init.count, "DRINK_PREF"));
/* 146 */     init.onArrivalStats.add(this.DRINK_PREFFERENCE); byte b; int j;
/*     */     All[] arrayOfAll;
/* 148 */     for (j = (arrayOfAll = this.foodAllowed).length, b = 0; b < j; ) { All bb = arrayOfAll[b];
/* 149 */       bb.clear(); b++; }
/*     */     
/* 151 */     init.savers.put("FOOD_ALLOWED", new SAVABLE()
/*     */         {
/*     */           public void save(FilePutter file)
/*     */           {
/* 155 */             HCLASSES.MAP().saver().save((SAVABLE[])StatsFood.this.foodAllowed, file);
/*     */           }
/*     */ 
/*     */           
/*     */           public void load(FileGetter file) throws IOException {
/* 160 */             HCLASSES.MAP().loader().load((SAVABLE[])StatsFood.this.foodAllowed, file);
/*     */           }
/*     */           public void clear() { byte b;
/*     */             int i;
/*     */             StatsFood.All[] arrayOfAll;
/* 165 */             for (i = (arrayOfAll = StatsFood.this.foodAllowed).length, b = 0; b < i; ) { StatsFood.All bb = arrayOfAll[b];
/* 166 */               bb.clear();
/*     */               b++; }
/*     */              }
/*     */         });
/* 170 */     LIST<RESOURCE> perm = RESOURCES.EDI().res().join(RESOURCES.DRINKS().res());
/* 171 */     ArrayList<PERMISSION> food = new ArrayList(perm.size());
/* 172 */     for (RESOURCE res : perm) {
/* 173 */       food.add(new PERMISSION()
/*     */           {
/*     */             public void set(HCLASS cl, Race race, boolean value)
/*     */             {
/* 177 */               if (race == null) {
/* 178 */                 for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 179 */                   set(cl, (Race)RACES.all().get(ri), value);
/*     */                 }
/*     */                 return;
/*     */               } 
/* 183 */               if (value) {
/* 184 */                 (StatsFood.this.foodAllowed[cl.index()]).foodAllowed[race.index].or(res);
/*     */               } else {
/* 186 */                 (StatsFood.this.foodAllowed[cl.index()]).foodAllowed[race.index].clear(res);
/*     */               } 
/*     */             }
/*     */             
/*     */             public INFO info() {
/* 191 */               return (INFO)res;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean get(HCLASS cl, Race race) {
/* 196 */               if (race == null) {
/* 197 */                 for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 198 */                   if (get(cl, (Race)RACES.all().get(ri)))
/* 199 */                     return true; 
/*     */                 } 
/* 201 */                 return false;
/*     */               } 
/* 203 */               return (StatsFood.this.foodAllowed[cl.index()]).foodAllowed[race.index].has(res);
/*     */             }
/*     */           });
/*     */     } 
/* 207 */     this.food = (LIST<PERMISSION>)food;
/*     */   }
/*     */   
/*     */   public PERMISSION foodAllowed(ResG e) {
/* 211 */     return (PERMISSION)this.food.get(e.index());
/*     */   }
/*     */   
/*     */   public PERMISSION drinkAllowed(ResG e) {
/* 215 */     return (PERMISSION)this.food.get(e.index());
/*     */   }
/*     */   
/*     */   public PERMISSION allowed(int index) {
/* 219 */     return (PERMISSION)this.food.get(index);
/*     */   }
/*     */   
/*     */   public RBIT fetchMask(Humanoid h) {
/* 223 */     return (RBIT)(this.foodAllowed[h.indu().hType().parentClass().index()]).foodAllowed[(h.race()).index];
/*     */   }
/*     */   
/*     */   public void eat(Humanoid a, int level, double preference) {
/* 227 */     Induvidual i = a.indu();
/* 228 */     (NEEDS.TYPES()).HUNGER.stat().fix(a.indu());
/* 229 */     this.FOOD.indu().set(i, Math.max(level - 1, 0));
/* 230 */     this.FOOD_PREFFERENCE.indu().setD(i, preference);
/*     */   }
/*     */   
/*     */   public void drink(Humanoid a, int level, double preference) {
/* 234 */     Induvidual i = a.indu();
/*     */     
/* 236 */     this.DRINK.indu().set(i, level);
/* 237 */     this.DRINK_PREFFERENCE.indu().setD(i, preference);
/*     */   }
/*     */   
/*     */   private static class All
/*     */     implements SAVABLE {
/* 242 */     public final RBIT.RBITImp[] foodAllowed = new RBIT.RBITImp[RACES.all().size()];
/*     */     
/*     */     All() {
/* 245 */       for (int i = 0; i < this.foodAllowed.length; i++) {
/* 246 */         this.foodAllowed[i] = new RBIT.RBITImp();
/*     */       }
/*     */     }
/*     */     
/*     */     public void save(FilePutter file) {
/* 251 */       RACES.map().saver().save((SAVABLE[])this.foodAllowed, file);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 256 */       RACES.map().loader().load((SAVABLE[])this.foodAllowed, file);
/*     */     } public void clear() {
/*     */       byte b;
/*     */       int i;
/*     */       RBIT.RBITImp[] arrayOfRBITImp;
/* 261 */       for (i = (arrayOfRBITImp = this.foodAllowed).length, b = 0; b < i; ) { RBIT.RBITImp rBITImp = arrayOfRBITImp[b];
/* 262 */         rBITImp.setAll();
/*     */         b++; }
/*     */     
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsFood.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */