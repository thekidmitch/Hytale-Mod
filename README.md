# Hytale AI Settlement

An experimental Hytale mod exploring AI-powered companions and autonomous NPC settlement systems.

The project currently focuses on **Erik**, an AI companion designed to communicate naturally with players, maintain persistent memories, develop relationships, and track personal goals.

## Project Status

**Experimental — active development**

The project has demonstrated:
- A Java-based Hytale plugin.
- Local AI conversation integration through Ollama.
- Persistent conversation and player-related memory.
- Personality, preferences, and relationship tracking.
- Independent goal and journal data.
- An NPC role definition for Erik.
- Successful NPC spawning in a test world.

NPC movement, duplicate-spawn prevention, and deeper autonomous behavior remain areas for development. This is not yet a finished settlement simulation.

## Vision

The long-term goal is to create believable NPCs that can:
- Remember interactions and important events.
- Develop individual personalities, preferences, and opinions.
- Form relationships with players and other NPCs.
- Create and pursue independent goals.
- Perform useful activities in a settlement.
- Cooperate, disagree, build, trade, and respond to changing circumstances.

The eventual settlement system is intended to support small groups of independently behaving NPCs.

## Current Architecture

- **Hytale plugin:** Java integration with the Hytale server.
- **AI backend:** Local Ollama integration.
- **NPC data:** Custom NPC role and data-pack definitions.
- **Persistent state:** Memory, journal, preference, goal, and relationship data.

See [Architecture](docs/ARCHITECTURE.md), [Features](docs/FEATURES.md), and [Roadmap](docs/ROADMAP.md).

## Requirements

- Hytale and a compatible server environment.
- Java development/runtime environment compatible with the project.
- Ollama installed locally.
- A locally available language model supported by Ollama.

Exact compatibility requirements and installation instructions will be documented as development progresses.

## Repository Structure

```text
Hytale-AI-Settlement/
├── src/
│   └── main/java/com/mitch/aicompanion/
├── datapack/
│   └── Server/NPC/Roles/
├── docs/
├── manifest.json
└── README.md
```

## Development Philosophy

- Prioritize local AI and avoid mandatory paid AI services.
- Build incrementally and test against the actual Hytale environment.
- Keep NPC behavior persistent and individual.
- Clearly distinguish implemented features from planned features.
- Do not redistribute proprietary Hytale files or third-party assets.

## Inspiration

The settlement design takes inspiration from simulation games such as Noble Fates. This project is an independent implementation; it does not include Noble Fates source code or assets.

## Contributions

Feedback, testing, and technical discussion are welcome. The project is experimental, and APIs or implementation details may change.

## License

No open-source license has been selected yet. Until one is added, all rights are reserved by the respective copyright holders.
