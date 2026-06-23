/*     */ package init.race.bio;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER_TRANS;
/*     */ import util.text.INSERT;
/*     */ import util.text.Inserter;
/*     */ 
/*     */ public class BioLine
/*     */ {
/*     */   CharSequence[] strings;
/*     */   protected boolean nl = false;
/*     */   protected final int index;
/*  22 */   private static Str str = new Str(256);
/*     */   final String key;
/*  24 */   public static final Inserter<Humanoid> insert = new Inserter(INSERT.human, "");
/*     */   static {
/*  26 */     insert.join(new Inserter(INSERT.human, "FRIEND_"), new GETTER_TRANS<Humanoid, Humanoid>()
/*     */         {
/*     */           public Humanoid get(Humanoid a)
/*     */           {
/*  30 */             ENTITY b = (ENTITY)(STATS.POP()).FRIEND.get(a.indu());
/*  31 */             if (b instanceof Humanoid) {
/*  32 */               return (Humanoid)b;
/*     */             }
/*  34 */             int ri = STATS.RAN().get(a.indu(), 1);
/*  35 */             ENTITY[] es = SETT.ENTITIES().getAllEnts();
/*     */             
/*  37 */             if (es.length == 0) {
/*  38 */               return a;
/*     */             }
/*  40 */             for (int i = 0; i < es.length; i++) {
/*  41 */               ENTITY e = es[MATH.mod(i + ri, es.length)];
/*  42 */               if (e != a && e instanceof Humanoid) {
/*  43 */                 return (Humanoid)e;
/*     */               }
/*     */             } 
/*     */             
/*  47 */             return a;
/*     */           }
/*     */         });
/*     */     
/*  51 */     insert.join(INSERT.faction, new GETTER_TRANS<Humanoid, Faction>()
/*     */         {
/*     */           public Faction get(Humanoid f)
/*     */           {
/*  55 */             return (Faction)FACTIONS.player();
/*     */           }
/*     */         });
/*     */     
/*  59 */     insert.join(INSERT.player, new GETTER_TRANS<Humanoid, Integer>()
/*     */         {
/*     */           public Integer get(Humanoid f)
/*     */           {
/*  63 */             return Integer.valueOf(STATS.RAN().get(f.indu(), 21, 10));
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   BioLine(LISTE<BioLine> all, Json json, String key) {
/*  70 */     if (json.has(key)) {
/*  71 */       this.strings = strings(json, key);
/*     */     } else {
/*  73 */       this.strings = new CharSequence[0];
/*  74 */     }  this.index = all.add(this);
/*  75 */     this.key = key;
/*     */   }
/*     */   
/*     */   BioLine(LISTE<BioLine> all, Json json, String key, CharSequence[] backup) {
/*  79 */     if (json.has(key)) {
/*  80 */       this.strings = strings(json, key);
/*     */     } else {
/*  82 */       this.strings = backup;
/*  83 */     }  this.index = all.add(this);
/*  84 */     this.key = key;
/*     */   }
/*     */   
/*     */   protected CharSequence[] strings(Json json, String key) {
/*  88 */     String[] arrayOfString = json.texts(key);
/*  89 */     insert.check((CharSequence[])arrayOfString);
/*     */     
/*  91 */     return (CharSequence[])arrayOfString;
/*     */   }
/*     */   
/*     */   protected boolean use(Humanoid a) {
/*  95 */     if (!(a.indu().hType()).CLASS.player)
/*  96 */       return false; 
/*  97 */     return true;
/*     */   }
/*     */   
/*     */   protected BioLine nlSet() {
/* 101 */     this.nl = true;
/* 102 */     return this;
/*     */   }
/*     */   
/*     */   public final CharSequence get(Humanoid a) {
/* 106 */     if (this.strings.length == 0)
/* 107 */       return null; 
/* 108 */     if (!use(a))
/* 109 */       return null; 
/* 110 */     int ran = STATS.RAN().get(a.indu(), 9 + this.index * 5, 5);
/* 111 */     CharSequence s = this.strings[MATH.mod(ran, this.strings.length)];
/* 112 */     str.clear().add(s);
/*     */     
/* 114 */     Inserter.setRandom(STATS.RAN().getL(a.indu(), 0));
/* 115 */     insert.set(str, a);
/*     */     
/* 117 */     return (CharSequence)str;
/*     */   }
/*     */   
/*     */   public boolean nl() {
/* 121 */     return this.nl;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\bio\BioLine.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */