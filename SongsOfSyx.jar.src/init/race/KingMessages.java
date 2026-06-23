/*     */ package init.race;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.paths.PATHS;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.Debugger;
/*     */ import util.data.GETTER_TRANS;
/*     */ import util.text.INSERT;
/*     */ import util.text.Inserter;
/*     */ import view.interrupter.IDebugPanel;
/*     */ 
/*     */ public class KingMessages
/*     */ {
/*  25 */   private final LinkedList<Message> all = new LinkedList();
/*     */   
/*     */   public final Message GREETING_GOOD;
/*     */   
/*     */   public final Message GREETING_BAD;
/*     */   
/*     */   public final Message STANCE_WARNING;
/*     */   
/*     */   public final Message STANCE_DOWN;
/*     */   
/*     */   public final Message STANCE_UP;
/*     */   
/*     */   public final Message PEACE_GOOD;
/*     */   
/*     */   public final Message PEACE_BAD;
/*     */   public final Message THREAT_NORMAL;
/*     */   public final Message THREAT_VASSAL;
/*     */   public final Message THREAT_ALLY;
/*     */   public final Message WAR_NORMAL;
/*     */   public final Message WAR_VASSAL;
/*     */   public final Message WAR_ALLY;
/*     */   public final Message WAR_JOIN_NORMAL;
/*     */   public final Message WAR_JOIN_VASSAL;
/*     */   public final Message WAR_JOIN_ALLY;
/*     */   public final LIST<CharSequence> COALITION_NAME;
/*     */   public final LIST<CharSequence> WAR_CAUSE_AGRESSION;
/*     */   public final LIST<CharSequence> WAR_CAUSE_DEFEND;
/*     */   public final LIST<CharSequence> RUMOUR;
/*     */   public final LIST<CharSequence> NGO;
/*     */   
/*     */   public static KingMessages make(Json data, ExpandInit init) {
/*  56 */     String key = data.value("KING_FILE");
/*  57 */     if (!init.kmessagess.containsKey(key)) {
/*  58 */       KingMessages m = new KingMessages(new Json((PATHS.RACE()).text.getFolder("king").gets(key)));
/*  59 */       init.kmessagess.put(key, m);
/*  60 */       IDebugPanel.add("King message test: " + key, new ACTION()
/*     */           {
/*     */             public void exe()
/*     */             {
/*  64 */               FactionNPC f = (FactionNPC)FACTIONS.NPCs().rnd();
/*  65 */               KingMessages m = (f.court().king().roy()).induvidual.race().kingMessage();
/*     */               
/*  67 */               for (KingMessages.Message me : m.all) {
/*  68 */                 LOG.ln(me.key);
/*  69 */                 for (int i = 0; i < me.all.length; i++) {
/*  70 */                   LOG.ln(me.get(f, i));
/*     */                 }
/*  72 */                 LOG.ln();
/*     */               } 
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  80 */     return (KingMessages)init.kmessagess.get(key);
/*     */   }
/*     */ 
/*     */   
/*     */   public KingMessages(Json j) {
/*  85 */     this.GREETING_GOOD = new Message(j, "GREETING_GOOD");
/*  86 */     this.GREETING_BAD = new Message(j, "GREETING_BAD");
/*  87 */     this.STANCE_UP = new Message(j, "STANCE_UP");
/*  88 */     this.STANCE_DOWN = new Message(j, "STANCE_DOWN");
/*  89 */     this.STANCE_WARNING = new Message(j, "STANCE_WARNING");
/*  90 */     this.PEACE_GOOD = new Message(j, "PEACE_GOOD");
/*  91 */     this.PEACE_BAD = new Message(j, "PEACE_BAD");
/*     */     
/*  93 */     this.THREAT_NORMAL = new Message(j, "THREAT_NORMAL");
/*  94 */     this.THREAT_VASSAL = new Message(j, "THREAT_VASSAL");
/*  95 */     this.THREAT_ALLY = new Message(j, "THREAT_ALLY");
/*  96 */     this.WAR_NORMAL = new Message(j, "WAR_NORMAL");
/*  97 */     this.WAR_VASSAL = new Message(j, "WAR_VASSAL");
/*  98 */     this.WAR_ALLY = new Message(j, "WAR_ALLY");
/*  99 */     this.WAR_JOIN_NORMAL = new Message(j, "WAR_JOIN_NORMAL");
/* 100 */     this.WAR_JOIN_VASSAL = new Message(j, "WAR_JOIN_VASSAL");
/* 101 */     this.WAR_JOIN_ALLY = new Message(j, "WAR_JOIN_ALLY");
/*     */ 
/*     */     
/* 104 */     this.COALITION_NAME = (LIST<CharSequence>)new ArrayList((Object[])j.texts("COALITION_NAME"));
/* 105 */     this.WAR_CAUSE_AGRESSION = (LIST<CharSequence>)new ArrayList((Object[])j.texts("WAR_CAUSE_AGRESSION"));
/* 106 */     this.WAR_CAUSE_DEFEND = (LIST<CharSequence>)new ArrayList((Object[])j.texts("WAR_CAUSE_DEFEND"));
/* 107 */     this.RUMOUR = (LIST<CharSequence>)new ArrayList((Object[])j.texts("RUMOUR"));
/* 108 */     this.NGO = (LIST<CharSequence>)new ArrayList((Object[])j.texts("NGO"));
/*     */   }
/*     */ 
/*     */   
/* 112 */   static final Inserter<FactionNPC> insert = new Inserter();
/*     */   
/*     */   private FactionNPC debug;
/*     */   
/*     */   static {
/* 117 */     insert.join(INSERT.faction, new GETTER_TRANS<FactionNPC, Faction>()
/*     */         {
/*     */           public Faction get(FactionNPC f)
/*     */           {
/* 121 */             return (Faction)f;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 126 */     insert.join(new Inserter(INSERT.faction, "PLAYER_"), new GETTER_TRANS<FactionNPC, Faction>()
/*     */         {
/*     */           public Faction get(FactionNPC f)
/*     */           {
/* 130 */             return (Faction)FACTIONS.player();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 137 */     insert.join(INSERT.player, new GETTER_TRANS<FactionNPC, Integer>()
/*     */         {
/*     */           public Integer get(FactionNPC f)
/*     */           {
/* 141 */             return Integer.valueOf(RND.rInt());
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 146 */     insert.join(INSERT.indu, new GETTER_TRANS<FactionNPC, Induvidual>()
/*     */         {
/*     */           public Induvidual get(FactionNPC f)
/*     */           {
/* 150 */             return (f.court().king().roy()).induvidual;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 155 */     insert.getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     insert.getClass();
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
/*     */   
/* 175 */   private static final Str TMP = new Str(250);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class Message
/*     */   {
/*     */     private final CharSequence[] all;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String key;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private ACTION da;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Message(Json j, String key) {
/* 201 */       this.da = new ACTION()
/*     */         {
/* 203 */           int ii = 0;
/*     */ 
/*     */           
/*     */           public void exe() {
/* 207 */             CharSequence m = KingMessages.Message.this.get((KingMessages.Message.access$0(KingMessages.Message.this)).debug, this.ii);
/* 208 */             this.ii++;
/* 209 */             if (this.ii >= KingMessages.Message.this.all.length)
/* 210 */               this.ii = 0; 
/* 211 */             LOG.ln(m); }
/*     */         };
/*     */       this.all = KingMessages.insert.check((CharSequence[])j.texts(key));
/*     */       KingMessages.this.all.add(this);
/*     */       this.key = key;
/*     */     } public CharSequence get(FactionNPC f) { return get(f, RND.rInt(this.all.length)); } private CharSequence get(FactionNPC f, int mi) { KingMessages.TMP.clear();
/*     */       KingMessages.TMP.add(this.all[mi]);
/*     */       KingMessages.insert.set(KingMessages.TMP, f);
/* 219 */       return (CharSequence)KingMessages.TMP; } } public void debug(Debugger d, FactionNPC f) { this.debug = f;
/*     */     
/* 221 */     d.title(KingMessages.class.getSimpleName());
/* 222 */     for (Message m : this.all)
/* 223 */       d.debug(m.key, m.da);  }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\KingMessages.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */