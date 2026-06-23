/*     */ package world.entity.army;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Stack;
/*     */ import util.text.Dic;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSingle;
/*     */ import view.world.panel.IDebugPanelWorld;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.WDivRegional;
/*     */ import world.entity.WEntity;
/*     */ import world.entity.WEntityConstructor;
/*     */ 
/*     */ public final class WArmyConstructor extends WEntityConstructor<WArmy> {
/*  23 */   private final Stack<WArmy> free = new Stack(512);
/*  24 */   private WArmy[] all = new WArmy[128];
/*  25 */   private int amount = 0;
/*  26 */   final WArmySprite sprite = new WArmySprite();
/*     */   private boolean tmpStop;
/*     */   public static final int MAX = 1024;
/*     */   
/*     */   public WArmyConstructor(LISTE<WEntityConstructor<? extends WEntity>> all) throws IOException {
/*  31 */     super(all, true);
/*  32 */     IDebugPanelWorld.add((PLACABLE)new PlacableSingle("ArmyBig")
/*     */         {
/*     */           public void placeFirst(int tx, int ty)
/*     */           {
/*  36 */             if (!FACTIONS.player().armies().canCreate())
/*     */               return; 
/*  38 */             WArmy e = WArmyConstructor.this.create(tx, ty, (Faction)FACTIONS.player());
/*  39 */             for (int i = 0; i <= 100; i++) {
/*     */ 
/*     */               
/*  42 */               WDivRegional d = AD.regional().create((Race)RACES.all().rnd(), 0.25D + 0.75D * (1.0D - (1.0F - RND.rFloatP(2.0F))), e);
/*  43 */               d.randomize(RND.rFloat(), RND.rFloat());
/*  44 */               d.menSet(d.menTarget());
/*     */             } 
/*  46 */             AD.supplies().fillAll(e);
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty) {
/*  51 */             return (WORLD.PATH()).map.is.is(tx, ty) ? null : E;
/*     */           }
/*     */         });
/*     */     
/*  55 */     IDebugPanelWorld.add((PLACABLE)new PlacableSingle("ArmySmall")
/*     */         {
/*     */           public void placeFirst(int tx, int ty)
/*     */           {
/*  59 */             WArmy e = WArmyConstructor.this.create(tx, ty, (Faction)FACTIONS.player());
/*  60 */             for (int i = 0; i <= 1; i++) {
/*     */ 
/*     */               
/*  63 */               WDivRegional d = AD.regional().create((Race)RACES.all().rnd(), 0.25D + 0.75D * (1.0D - (1.0F - RND.rFloatP(2.0F))), e);
/*  64 */               d.randomize(RND.rFloat(), RND.rFloat());
/*  65 */               d.menSet(d.menTarget());
/*     */             } 
/*  67 */             AD.supplies().fillAll(e);
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty) {
/*  72 */             return (WORLD.PATH()).map.is.is(tx, ty) ? null : E;
/*     */           }
/*     */         });
/*     */     
/*  76 */     IDebugPanelWorld.add((PLACABLE)new PlacableSingle("ArmyEnemyBig")
/*     */         {
/*     */           public void placeFirst(int tx, int ty)
/*     */           {
/*  80 */             WArmy e = WArmyConstructor.this.create(tx, ty, null);
/*  81 */             AD.factionSet(e, null);
/*  82 */             for (int i = 0; i <= 100; i++) {
/*     */               
/*  84 */               WDivRegional d = AD.regional().create((Race)RACES.all().rnd(), 0.25D + 0.75D * (1.0D - (1.0F - RND.rFloatP(2.0F))), e);
/*  85 */               d.randomize(RND.rFloat(), RND.rFloat());
/*  86 */               d.menSet(d.menTarget());
/*     */             } 
/*  88 */             AD.supplies().fillAll(e);
/*  89 */             AD.updateArmy(e);
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty) {
/*  94 */             return (WORLD.PATH()).map.is.is(tx, ty) ? null : E;
/*     */           }
/*     */         });
/*     */     
/*  98 */     IDebugPanelWorld.add((PLACABLE)new PlacableSingle("ArmyEnemySmall")
/*     */         {
/*     */           public void placeFirst(int tx, int ty)
/*     */           {
/* 102 */             WArmy e = WArmyConstructor.this.create(tx, ty, null);
/*     */ 
/*     */ 
/*     */             
/* 106 */             WDivRegional d = AD.regional().create((Race)RACES.all().rnd(), 0.25D + 0.75D * (1.0D - (1.0F - RND.rFloatP(2.0F))), e);
/* 107 */             d.randomize(RND.rFloat(), RND.rFloat());
/* 108 */             d.menSet(d.menTarget());
/* 109 */             AD.supplies().fillAll(e);
/* 110 */             AD.updateArmy(e);
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty) {
/* 115 */             return (WORLD.PATH()).map.is.is(tx, ty) ? null : E;
/*     */           }
/*     */         });
/*     */     
/* 119 */     IDebugPanelWorld.add((PLACABLE)new PlacableSingle("ArmyEnemyFaction")
/*     */         {
/*     */           public void placeFirst(int tx, int ty)
/*     */           {
/* 123 */             Faction f = (Faction)FACTIONS.NPCs().get(0);
/* 124 */             if (f.capitolRegion() == null)
/*     */               return; 
/* 126 */             WArmy e = WArmyConstructor.this.create(tx, ty, f);
/* 127 */             for (int i = 0; i <= 50; i++) {
/*     */ 
/*     */               
/* 130 */               WDivRegional d = AD.regional().create((Race)RACES.all().rnd(), 0.25D + 0.75D * (1.0D - (1.0F - RND.rFloatP(2.0F))), e);
/* 131 */               d.randomize(RND.rFloat(), RND.rFloat());
/* 132 */               d.menSet(d.menTarget());
/*     */             } 
/* 134 */             AD.supplies().fillAll(e);
/* 135 */             DIP.WAR().set(f, (Faction)FACTIONS.player());
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty) {
/* 140 */             return (WORLD.PATH()).map.is.is(tx, ty) ? null : E;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected WArmy create() {
/* 148 */     if (!this.free.isEmpty())
/* 149 */       return (WArmy)this.free.pop(); 
/* 150 */     return new WArmy();
/*     */   }
/*     */   
/*     */   public boolean tmpStop() {
/* 154 */     return this.tmpStop;
/*     */   }
/*     */   
/*     */   public int armies() {
/* 158 */     return this.amount;
/*     */   }
/*     */   
/*     */   public int max() {
/* 162 */     return this.all.length;
/*     */   }
/*     */   
/*     */   public WArmy get(int index) {
/* 166 */     return this.all[index];
/*     */   }
/*     */   
/*     */   public WArmy tryGet(int index) {
/* 170 */     if (index < 0 || index > this.all.length)
/* 171 */       return null; 
/* 172 */     return this.all[index];
/*     */   }
/*     */   
/*     */   public boolean canCreate() {
/* 176 */     return (this.amount < 1024 && WORLD.ENTITIES().canAdd(this.fast));
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
/*     */   public WArmy create(int tx, int ty, Faction f) {
/* 188 */     if (!canCreate()) {
/* 189 */       throw new RuntimeException("too many armies on the map! " + this.amount + " " + WORLD.ENTITIES().allFast().size());
/*     */     }
/*     */     
/* 192 */     for (int i = 0; i < this.all.length; i++) {
/* 193 */       if (this.all[i] == null) {
/* 194 */         return add(create(), i, tx, ty, f);
/*     */       }
/*     */     } 
/*     */     
/* 198 */     int nsize = this.all.length + 64;
/* 199 */     if (nsize > 32767)
/* 200 */       nsize = 32767; 
/* 201 */     if (nsize <= this.all.length) {
/* 202 */       throw new RuntimeException();
/*     */     }
/* 204 */     WArmy[] newAll = new WArmy[nsize]; int j;
/* 205 */     for (j = 0; j < this.all.length; j++) {
/* 206 */       newAll[j] = this.all[j];
/*     */     }
/* 208 */     j = this.all.length;
/* 209 */     this.all = newAll;
/* 210 */     return add(create(), j, tx, ty, f);
/*     */   }
/*     */   
/*     */   public void ret(WArmy wArmyEntity) {
/* 214 */     this.all[wArmyEntity.index] = null;
/* 215 */     if (!this.free.isFull()) {
/* 216 */       this.free.push(wArmyEntity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WArmy add(WArmy a, int index, int tx, int ty, Faction f) {
/* 224 */     a.index = (short)index;
/* 225 */     this.all[index] = a;
/* 226 */     a.init(tx, ty, f);
/* 227 */     if (!a.added())
/* 228 */       throw new RuntimeException(); 
/* 229 */     this.amount++;
/*     */     
/* 231 */     a.name.clear();
/* 232 */     if (f != null) {
/* 233 */       a.name.add(Dic.¤¤Army).s().add(f.armies().all().size());
/*     */     } else {
/* 235 */       a.name.add(Dic.¤¤Army);
/*     */     } 
/* 237 */     return a;
/*     */   }
/*     */ 
/*     */   
/*     */   WArmy load(WArmy a) {
/* 242 */     if (a.index > this.all.length) {
/* 243 */       WArmy[] nn = this.all;
/* 244 */       while (a.index > nn.length)
/* 245 */         nn = new WArmy[nn.length + 64]; 
/* 246 */       for (int i = 0; i < this.all.length; i++)
/* 247 */         nn[i] = this.all[i]; 
/* 248 */       this.all = nn;
/*     */     } 
/* 250 */     this.all[a.index] = a;
/* 251 */     this.amount++;
/* 252 */     return a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 258 */     this.all = new WArmy[128];
/* 259 */     this.amount = 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\army\WArmyConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */