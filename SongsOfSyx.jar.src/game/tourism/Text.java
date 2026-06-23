/*     */ package game.tourism;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.service.StatService;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER_TRANS;
/*     */ import util.text.INSERT;
/*     */ import util.text.Inserter;
/*     */ 
/*     */ final class Text
/*     */ {
/*  28 */   public static final Inserter<InsertData> insert = new Inserter();
/*     */   
/*     */   static {
/*  31 */     insert.join(INSERT.indu, new GETTER_TRANS<InsertData, Induvidual>()
/*     */         {
/*     */           public Induvidual get(Text.InsertData f)
/*     */           {
/*  35 */             return f.i;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  40 */     insert.join(INSERT.faction, new GETTER_TRANS<InsertData, Faction>()
/*     */         {
/*     */           public Faction get(Text.InsertData f)
/*     */           {
/*  44 */             return (Faction)FACTIONS.player();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  49 */     insert.join(INSERT.player, new GETTER_TRANS<InsertData, Integer>()
/*     */         {
/*     */           public Integer get(Text.InsertData f)
/*     */           {
/*  53 */             return Integer.valueOf(STATS.RAN().get(f.i, 0));
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  58 */     insert.getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  67 */     insert.getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     insert.getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     insert.getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     insert.getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     insert.getClass();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class InsertData
/*     */   {
/*     */     public double rating;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Induvidual i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public COORDINATE inn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 138 */   public static final InsertData dd = new InsertData();
/*     */   
/*     */   public final Entry rating;
/*     */   
/*     */   public final Entry attraction;
/*     */   public final Entry service;
/*     */   public final Entry inn;
/* 145 */   private static final Str str = new Str(128);
/*     */   
/*     */   public Text(Json json) {
/* 148 */     this.rating = new Entry(0, json, "RATING");
/* 149 */     this.attraction = new Entry(1, json, "ATTRACTION");
/* 150 */     this.service = new Entry(2, json, "SERVICE");
/* 151 */     this.inn = new Entry(3, json, "INN");
/*     */   }
/*     */   
/*     */   static class Entry
/*     */   {
/* 156 */     private CharSequence[][] chars = new CharSequence[3][];
/*     */     private final int scroll;
/*     */     
/*     */     Entry(int index, Json json, String key) {
/* 160 */       this.scroll = index * 8;
/* 161 */       if (json != null) {
/* 162 */         json = json.json(key);
/* 163 */         this.chars[0] = Text.insert.check((CharSequence[])json.texts("BAD"));
/* 164 */         this.chars[1] = Text.insert.check((CharSequence[])json.texts("OK"));
/* 165 */         this.chars[2] = Text.insert.check((CharSequence[])json.texts("GOOD"));
/*     */       } else {
/* 167 */         (new CharSequence[1])[0] = ""; this.chars[0] = new CharSequence[1];
/* 168 */         (new CharSequence[1])[0] = ""; this.chars[1] = new CharSequence[1];
/* 169 */         (new CharSequence[1])[0] = ""; this.chars[2] = new CharSequence[1];
/*     */       } 
/*     */     }
/*     */     
/*     */     public Str get(Text.InsertData data) {
/* 174 */       int ri = (int)Math.round(data.rating * 2.0D - 0.25D);
/* 175 */       ri = CLAMP.i(ri, 0, 2);
/* 176 */       int r = STATS.RAN().get(data.i, this.scroll);
/* 177 */       Text.str.clear().add(this.chars[ri][MATH.mod(r, (this.chars[ri]).length)]);
/* 178 */       Text.insert.set(Text.str, data);
/* 179 */       return Text.str;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\tourism\Text.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */