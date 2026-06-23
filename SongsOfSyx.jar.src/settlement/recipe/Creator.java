/*     */ package settlement.recipe;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.boosting.BoosterImp;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADABLEO;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryRegion;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ class Creator
/*     */ {
/*     */   static {
/*  47 */     D.ts(Recipes.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static LIST<Recipe> all(BoostableCat boostsSlave, CharSequence nname, CharSequence ndesc, ArrayListGrower<FBoost> fboosts) {
/*  53 */     ArrayListGrower<Recipe> all = new ArrayListGrower();
/*     */     
/*  55 */     for (int bi = 0; bi < SETT.ROOMS().all().size(); bi++) {
/*  56 */       RoomBlueprint b = (RoomBlueprint)SETT.ROOMS().all().get(bi);
/*     */       
/*  58 */       KeyMap<Boolean> hasBoosted = new KeyMap();
/*     */       
/*  60 */       if (b instanceof INDUSTRY_HASER) {
/*  61 */         INDUSTRY_HASER hh = (INDUSTRY_HASER)b;
/*  62 */         for (int ii = 0; ii < hh.industries().size(); ii++) {
/*  63 */           Industry i = (Industry)hh.industries().get(ii);
/*  64 */           if (!i.isOnlyRoomDoNotUse)
/*     */           {
/*     */             
/*  67 */             for (int oi = 0; oi < i.outs().size(); oi++) {
/*  68 */               SPRITE sPRITE; final IndustryResource r = (IndustryResource)i.outs().get(oi);
/*  69 */               int index = all.size();
/*  70 */               TRADABLE out = r.resource.tr();
/*  71 */               double rate = r.rate;
/*  72 */               double rateAI = r.AIRate;
/*  73 */               double aiRecovery = r.AIRecovery;
/*  74 */               Boostable bo = i.bonus();
/*  75 */               String name = " " + String.valueOf(i.blue.info.name);
/*  76 */               Icon icon = i.blue.icon;
/*  77 */               RESOURCE inn = uniqueResource(i, hh);
/*  78 */               if (inn != null) {
/*     */                 
/*  80 */                 name = name + "(" + name + ")";
/*  81 */                 sPRITE = icon.twin(inn.icon().scaled(0.5D), DIR.SE, 2);
/*     */               } 
/*     */               
/*  84 */               ArrayListGrower<RecipeInput> inss = new ArrayListGrower();
/*     */               
/*  86 */               for (IndustryResource in : i.ins()) {
/*  87 */                 inss.add(new RecipeInput(in.resource.tr(), in.rate, bo));
/*     */               }
/*     */               
/*  90 */               Recipe fi = new Recipe(index, ii, out, rate, rateAI, aiRecovery, bo, i.consumption(), name, sPRITE, (LIST<RecipeInput>)inss);
/*     */               
/*  92 */               all.add(fi);
/*     */               
/*  94 */               if (!hasBoosted.containsKey((i.bonus()).key)) {
/*  95 */                 if (i.reg() != null);
/*     */                 
/*  97 */                 fboosts.add(new FBoost(i.bonus()));
/*  98 */                 hasBoosted.put((i.bonus()).key, Boolean.valueOf(true));
/*     */               } 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     for (Race r : RACES.all()) {
/*     */       
/* 111 */       double w = r.physics.slaveprice;
/*     */       
/* 113 */       int index = all.size();
/* 114 */       TRADABLEO tRADABLEO = TR.get(r);
/*     */       
/* 116 */       double rate = 1.0D / w;
/* 117 */       double rateAI = 1.0D / w;
/*     */       
/* 119 */       if (r.physics.slavePRriceRecovery <= 0.0D) {
/* 120 */         rate = 0.0D;
/* 121 */         rateAI = 0.0D;
/*     */       } 
/* 123 */       double aiRecovery = r.physics.slavePRriceRecovery;
/* 124 */       SPRITE.Imp imp = new SPRITE.Imp(24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER re, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 128 */             (r.appearance()).icon.render(re, X1, X2, Y1, Y2);
/*     */           }
/*     */         };
/*     */       
/* 132 */       Boostable bo = BOOSTING.push(r.key, 1.0D, String.valueOf(nname) + ": " + String.valueOf(nname), ndesc, (SPRITE)imp, boostsSlave);
/* 133 */       String name = String.valueOf(r.info.names);
/*     */ 
/*     */       
/* 136 */       ArrayListGrower<RecipeInput> inss = new ArrayListGrower();
/* 137 */       Recipe fi = new Recipe(index, 0, (TRADABLE)tRADABLEO, rate, rateAI, aiRecovery, bo, null, name, (SPRITE)imp, (LIST<RecipeInput>)inss);
/*     */       
/* 139 */       all.add(fi);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     return (LIST<Recipe>)all;
/*     */   }
/*     */   
/*     */   private static RESOURCE uniqueResource(Industry ins, INDUSTRY_HASER hs) {
/* 149 */     if (hs.industries().size() == 1) {
/* 150 */       return null;
/*     */     }
/* 152 */     if (ins.outs().size() > 0) {
/* 153 */       RESOURCE res = ((IndustryResource)ins.outs().get(0)).resource;
/* 154 */       boolean unique = true;
/* 155 */       for (int ii = 0; ii < hs.industries().size(); ii++) {
/* 156 */         Industry io = (Industry)hs.industries().get(ii);
/* 157 */         if (io != ins)
/*     */         {
/* 159 */           if (((IndustryResource)io.outs().get(0)).resource == res)
/* 160 */             unique = false; 
/*     */         }
/*     */       } 
/* 163 */       if (unique) {
/* 164 */         return res;
/*     */       }
/*     */     } 
/* 167 */     for (Industry io : hs.industries()) {
/* 168 */       if (io == ins)
/*     */         continue; 
/* 170 */       for (int i1 = 0; i1 < ins.ins().size(); i1++) {
/* 171 */         IndustryResource in = (IndustryResource)ins.ins().get(i1);
/* 172 */         boolean contains = false;
/* 173 */         for (int i2 = 0; i2 < io.ins().size(); i2++) {
/* 174 */           IndustryResource ino = (IndustryResource)io.ins().get(i2);
/* 175 */           if (ino.resource == in.resource)
/* 176 */             contains = true; 
/*     */         } 
/* 178 */         if (!contains) {
/* 179 */           return in.resource;
/*     */         }
/*     */       } 
/*     */     } 
/* 183 */     return null;
/*     */   }
/*     */   
/*     */   private static class RegBoost
/*     */     extends BoosterImp
/*     */   {
/*     */     boolean changeAll;
/* 190 */     int[] lastSecond = Alloc.ii(FACTIONS.MAX());
/* 191 */     double[] cache = new double[FACTIONS.MAX()];
/*     */     private final IndustryRegion ireg;
/*     */     
/*     */     RegBoost(Boostable bo, IndustryRegion reg) {
/* 195 */       super(new BSourceInfo(Recipes.¤¤realm, (SPRITE)(UI.icons()).s.world), 0.0D, 2.0D, true);
/* 196 */       this.ireg = reg;
/* 197 */       add(bo);
/* 198 */       Arrays.fill(this.lastSecond, -2147483648);
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
/*     */     public double vGet(Region reg) {
/* 211 */       return 1.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Induvidual indu) {
/* 216 */       return 1.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Div div) {
/* 221 */       return 1.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(HCLASS_RACE t) {
/* 226 */       return 1.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Player f) {
/* 231 */       return 1.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(FactionNPC f) {
/* 236 */       if (this.changeAll) {
/* 237 */         Arrays.fill(this.lastSecond, -2147483648);
/* 238 */         this.changeAll = false;
/*     */       } 
/*     */ 
/*     */       
/* 242 */       if (TIME.currentSecond() - this.lastSecond[f.index()] > TIME.secondsPerDay()) {
/* 243 */         this.lastSecond[f.index()] = TIME.secondsPerDay();
/* 244 */         double b = 0.0D;
/* 245 */         for (int i = 0; i < f.realm().regions(); i++) {
/* 246 */           Region reg = f.realm().region(i);
/* 247 */           b += RD.PROSPECT().getAi(this.ireg, reg);
/*     */         } 
/* 249 */         b /= f.realm().regions();
/*     */ 
/*     */         
/* 252 */         this.cache[f.index()] = b;
/*     */       } 
/*     */       
/* 255 */       return this.cache[f.index()];
/*     */     }
/*     */ 
/*     */     
/*     */     public double getValue(double input) {
/* 260 */       return input;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\recipe\Creator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */